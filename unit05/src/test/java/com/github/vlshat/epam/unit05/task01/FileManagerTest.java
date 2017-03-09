package com.github.vlshat.epam.unit05.task01;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by vladislav on 08.03.17.
 */
public class FileManagerTest {

    @org.junit.Test
    public void testPwd() throws Exception {
        FileManager fileManager = new FileManager();
        File file = new File("");
        assertEquals(file.getAbsolutePath() + System.getProperty("file.separator"), fileManager.printWorkingDirectory());
    }

    @org.junit.Test
    public void testCdAndCdB() throws Exception {
        FileManager fileManager = new FileManager();
        File file = new File("ddir");
        file.mkdir();
        fileManager.changeDirectory("ddir");
        assertEquals(file.getAbsolutePath() + System.getProperty("file.separator"), fileManager.printWorkingDirectory());

        fileManager.cdB();
        assertEquals(new File("").getAbsolutePath() + System.getProperty("file.separator"), fileManager.printWorkingDirectory());
        file.delete();
    }
}