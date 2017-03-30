package com.github.vlshat.epam.course.datastructures;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class CustomListsTest {

    private List<String> list;

    public CustomListsTest(List<String> list) {
        this.list = list;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[]{
                new CustomArrayList(),
                new CustomLinkedList()
        });
    }

    @Before
    public void init() {
        list.clear();
    }

    @Test
    public void testThatNewListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatListNotEmptyAfterAddingElement() {
        list.add("aaaa");
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void testThatListContainsElementThatWeAddedBefore() {
        String value = "bbb";

        list.add(value);

        assertTrue(list.contains(value));
    }

    @Test
    public void testThatListNotContainsElementThatWasntAddedToList() throws Exception {
        list.add("fff");
        assertFalse(list.contains("ccc"));
    }

    @Test
    public void testThatListContainsNullIfItWasAdded() {

        list.add(null);

        assertTrue(list.contains(null));
    }

    @Test
    public void testThatListNotContainsNullIfItWasNotAdded() {
        list.add("fff");
        assertFalse(list.contains(null));
    }

    @Test
    public void testThatListsSizeIsDynamic() throws Exception {
        int size = 50;

        for (int i = 0; i < size; i++) {
            list.add(String.valueOf(i));
        }

        assertThat(list.size(), is(size));
    }

    @Test
    public void testThatWeCanGetElementByIndex() {

        fillList();

        assertThat(list.get(1), is(equalTo("aa1a")));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatWeCantGetElementByIndexMoreThenSize() throws Exception {

        fillList();

        list.get(list.size());
    }

    @Test
    public void testThatWeCanRemoveExistedElementFromList() throws Exception {
        fillList();

        list.remove("ssss");

        assertFalse("contains", list.contains("ssss"));
    }

    @Test
    public void testThatWeCanDeleteElementByIndex() throws Exception {
        fillList();

        String removed = list.remove(2);

        assertFalse(list.contains("aa2a"));
        assertThat(removed, is(equalTo("aa2a")));
    }

    @Test
    public void testThatWeCanDeleteLastElement() throws Exception {
        fillList();

        int prevSize = list.size();

        list.remove(list.size() - 1);

        assertFalse(list.contains("aa6a"));
        assertThat(list.size(), is(equalTo(prevSize - 1)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnableToDeleteElementByNegativeIndex() throws Exception {
        fillList();
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnableToDeleteElementByLargerIndex() throws Exception {
        fillList();
        list.remove(list.size());
    }


    @Test
    public void testThatWeCantDeleteNonExistentElement() throws Exception {
        fillList();

        assertFalse(list.remove("sadasdasd"));
    }

    @Test
    public void testAddingByIndex() throws Exception {
        fillList();
        int previousSize = list.size();

        list.add(3, "added");
        assertTrue(list.contains("added"));
        assertThat(list.get(3), is(equalTo("added")));
        assertTrue(list.size() == previousSize + 1);
    }

    @Test
    public void testSettingByIndex() throws Exception {
        fillList();
        int previousSize = list.size();

        list.set(3, "set");
        assertTrue(list.contains("set"));
        assertThat(list.get(3), is(equalTo("set")));
        assertTrue(list.size() == previousSize);
    }

    @Test
    public void testIndexOf() throws Exception {
        fillList();
        assertThat(list.indexOf("sss"), is(6));
    }

    @Test
    public void testIndexOfNotExistingElement() throws Exception {
        fillList();
        assertThat(list.indexOf(null), is(-1));
        assertThat(list.indexOf("aa"), is(-1));
    }

    @Test
    public void testLastIndexOf() {
        fillList();
        assertThat(list.lastIndexOf("sss"), is(list.size() - 2));
        assertThat(list.lastIndexOf("aa1a"), is(1));
    }

    @Test
    public void testLastIndexOfNotExistingElement() throws Exception {
        fillList();
        assertThat(list.lastIndexOf(null), is(-1));
        assertThat(list.lastIndexOf("aa"), is(-1));
    }

    private void fillList() {
        list.add("aa0a");
        list.add("aa1a");
        list.add("aa2a");
        list.add("ssss");
        list.add("aa3a");
        list.add("aa4a");
        list.add("sss");
        list.add("aa5a");
        list.add("sss");
        list.add("aa6a");
    }
}