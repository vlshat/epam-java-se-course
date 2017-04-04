package com.github.vlshat.epam.course.datastructures;

import org.junit.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by vladislav on 27.03.17.
 */
@FixMethodOrder
public class CustomHashMapTest {
    private Map<Integer, String> m;

    @Before
    public void init() {
        m = new CustomHashMap<>();
    }

    @Test
    public void testThatWeCanCreate() throws Exception{

        assertThat(m, is(notNullValue()));

    }

    @Test
    public void testThatNewMapIsEmpty() throws Exception{
        assertThat(m.isEmpty(), is(true));
    }

    @Test
    public void testThatOnNewMapContainKeyMethodReturnFalseForAnyObject() throws Exception{
        assertThat(m.containsKey(new Integer(1)), is(false));
    }

    @Test
    public void testThatWeCanPutKeyValuePairAndCanCheckIt() throws Exception{
        m.put(new Integer(3), "abc");
        assertThat(m.containsKey(3), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void testThatWeCantPutNullKey() throws Exception{
        m.put(null, "abc");
    }

    @Test
    public void testThatWeCanPutNullValue() throws Exception{
        m.put(1, null);
        assertThat(m.get(1), is(nullValue()));
    }

    @Test
    public void testThatGetMethodWorksProperly() throws Exception{
        m.put(1, "a");
        m.put(2, "b");
        assertThat(m.get(2), is("b"));
    }

    @Test
    public void testThatRemoveMethodWorks() throws Exception{
        m.put(1, "a");
        m.put(2, "b");
        int previousSize = m.size();

        assertThat(m.remove(3), is(nullValue()));
        assertThat(m.remove(2), is("b"));
        assertTrue(m.size() == previousSize - 1);
        assertFalse(m.containsKey(2));
        assertFalse(m.containsValue("b"));
    }

    @Test
    public void testContainsValueMethod() throws Exception {
        m.put(1, "a");
        m.put(2, "b");
        m.put(4, null);
        assertTrue(m.containsValue("b"));
        assertFalse(m.containsValue("q"));
        assertTrue(m.containsValue(null));
    }


    @Test
    public void testThatMapCanPutPairWithKeyThatAlreadyPresented() throws Exception{
        m.put(3, "abc");
        m.put(3, "new key");
        assertThat(m.get(3), is("new key"));
    }

    @Test
    public void testThatMapCanContainsKeysWithSameHashCode() throws Exception{
    }

    @Test(expected = NullPointerException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnNullKey() throws Exception{
        m.containsKey(null);
    }

    @Test(expected = ClassCastException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnWrongKeyClass() throws Exception{
        m.containsKey("aaa");
    }


    @Test
    public void testContainsValueMethodWorksProperlyOnNullInputValue() throws Exception{
    }

    @Test(expected = ClassCastException.class)
    @Ignore
    public void testValueContainsMethodThrowsExceptionOnWrongInputValueClass() throws Exception{
    }

    @Test
    public void testThatMapCalculateItsSizeProperly() throws Exception{
        m.put(1, "a");
        m.put(2, "b");
        assertThat(m.size(), is(2));
    }

    @Test
    public void testPutAll() throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "aaaa");
        map.put(12, "bbbb");

        m.putAll(map);
    }


}