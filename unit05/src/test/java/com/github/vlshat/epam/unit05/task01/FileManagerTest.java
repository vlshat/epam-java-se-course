package com.github.vlshat.epam.unit05.task01;

import org.junit.*;
import org.junit.Test;

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
        assertEquals(file.getAbsolutePath() + "/", fileManager.pwd());
    }

    @org.junit.Test
    public void testCdAndCdB() throws Exception {
        FileManager fileManager = new FileManager();
        File file = new File("ddir");
        file.mkdir();
        fileManager.cd("ddir");
        assertEquals(file.getAbsolutePath() + "/", fileManager.pwd());

        fileManager.cdB();
        assertEquals(new File("").getAbsolutePath() + "/", fileManager.pwd());
        file.delete();
    }
}