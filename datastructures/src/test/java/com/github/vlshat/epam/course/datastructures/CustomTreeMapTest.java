package com.github.vlshat.epam.course.datastructures;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder
public class CustomTreeMapTest {

    private Map<Integer, String> m;

    @Before
    public void init() {
        m = new CustomTreeMap<>();
    }

    @Test
    public void testThatWeCanCreate() {

        assertThat(m, is(notNullValue()));

    }

    @Test
    public void testThatNewMapIsEmpty() {
        assertThat(m.isEmpty(), is(true));
    }

    @Test
    public void testThatOnNewMapContainKeyMethodReturnFalseForAnyObject() {
        assertThat(m.containsKey(new Integer(1)), is(false));
    }

    @Test
    public void testThatWeCanPutKeyValuePairAndCanCheckIt() {
        m.put(1, "c");
        m.put(new Integer(3), "abc");
        assertThat(m.containsKey(3), is(true));
        assertThat(m.size(), is(2));
    }

    @Test
    public void testGeMethod() {
        m.put(new Integer(1), "a");
        m.put(new Integer(3), "b");
        assertThat(m.containsKey(3), is(true));
        assertThat(m.get(3), is("b"));
    }
    @Test
    public void testContainsValueMethod() {
        m.put(1, "a");
        m.put(2, "b");
        m.put(14, "g");
        m.put(15, "aaa");

        assertTrue(m.containsValue("b"));
        assertFalse(m.containsValue("c"));
    }

    @Test(expected = NullPointerException.class)
    public void testThatWeCantPutNullKey() {
        m.put(null, "abc");
    }

    @Test
    public void testThatWeCanPutNullValue() {
        m.put(1, null);
        assertThat(m.containsKey(1), is(true));
    }

    @Test
    public void testThatMapCanPutPairWithKeyThatAlreadyPresented() {

        String oldValue = "aaaa";
        String newValue = "bbbb";

        m.put(1, oldValue);
        m.put(1, newValue);

        assertFalse(m.containsValue(oldValue));
        assertTrue(m.containsValue(newValue));
    }

    @Test
    public void testThatIfWePutNewValueOnExistingKeyPreviousValueWillBeReturned() {
        String oldValue = "aaaa";
        String newValue = "bbbb";

        m.put(1, oldValue);
        String returnedValue = m.put(1, newValue);

        assertThat(oldValue, is(equalTo(returnedValue)));
    }

    @Test(expected = NullPointerException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnNullKey() {
        m.containsKey(null);
    }

    @Test(expected = ClassCastException.class)
    @Ignore
    public void testThatContainsKeyMethodThrowsExceptionOnWrongKeyClass() {
        m.put(1, ""); //TODO need to remove
        m.containsKey(new String(""));
    }

    @Test
    public void testContainsValueMethodWorksProperlyOnNullInputValue() {
        String value = "aaaa";

        m.put(1, value);

        assertFalse(m.containsValue(null));
    }

    @Test
    public void testThatWeCanPut10DifferentKeysInMap() {
        IntStream.range(1, 10).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        IntStream.range(1, 10).forEach(
                i -> assertTrue(m.containsKey(i))
        );
    }

    @Test(expected = ClassCastException.class)
    @Ignore
    public void testValueContainsMethodThrowsExceptionOnWrongInputValueClass() {

    }

    @Test
    @Ignore
    public void testThatMapCalculateItsSizeProperly() {
    }

    @Test
    public void removeFirstTestCase() {
        int[] keys = {8, 10, 5, 2};
        int keyToRemove = 5;

        for (int k : keys) {
            m.put(k, "a");
        }

        m.remove(keyToRemove);

        for (int k : keys) {
            if (k != keyToRemove) {
                assertTrue(m.containsKey(k));
            }
        }

        assertFalse(m.containsKey(keyToRemove));
    }

    @Test
    public void removeSecondTestCase() {
        int[] keys = {8, 10, 5, 2, 6, 7};
        int keyToRemove = 5;

        for (int k : keys) {
            m.put(k, "a");
        }

        m.remove(keyToRemove);

        for (int k : keys) {
            if (k != keyToRemove) {
                assertTrue(m.containsKey(k));
            }
        }

        assertFalse(m.containsKey(keyToRemove));
    }

    @Test
    @Ignore
    public void removeThirdTestCase() {
        int[] keys = {8, 10, 5, 2, 7, 6};
        int keyToRemove = 5;

        for (int k : keys) {
            m.put(k, "a");
        }

        m.remove(keyToRemove);

        for (int k : keys) {
            if (k != keyToRemove) {
                assertTrue(m.containsKey(k));
            }
        }

        assertFalse(m.containsKey(keyToRemove));
    }


}