package com.github.vlshat.epam.unit05.task02;

import com.github.vlshat.epam.unit05.task02.exceptions.PropertyFileNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vladislav on 13.03.17.
 */
public class PropertyManagerTest {

    @Test
    public void getResourceList() throws Exception {
        PropertyManager propertyManager = new PropertyManager();
        assertEquals("question_ru.properties\n" +
                "question_en.properties\n" +
                "empty_file.properties", propertyManager.getResourceList());

    }

    @Test(expected = PropertyFileNotFoundException.class)
    public void loadResource() throws Exception {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadResource("question_ru");
        propertyManager.loadResource("a");
    }

    @Test
    public void getValue() throws Exception {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadResource("question_en");
        assertEquals("The Ultimate Question of Life, the Universe, and Everything", propertyManager.getValue("q1"));
    }

}