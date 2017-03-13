package com.github.vlshat.epam.unit05.task01;

import com.github.vlshat.epam.unit05.task01.Exceptions.DirectoryNotFoundException;
import com.github.vlshat.epam.unit05.task01.Exceptions.FileExistsException;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

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

    @org.junit.Test(expected = DirectoryNotFoundException.class)
    public void testCdAndCdB() throws Exception {
        FileManager fileManager = new FileManager();
        File file = new File("ddir");
        file.mkdir();

        fileManager.changeDirectory("ddir");
        assertEquals(file.getAbsolutePath() + System.getProperty("file.separator"), fileManager.printWorkingDirectory());

        fileManager.goToThePreviousDirectory();
        assertEquals(new File("").getAbsolutePath() + System.getProperty("file.separator"), fileManager.printWorkingDirectory());
        file.delete();

        while (true){
            fileManager.goToThePreviousDirectory();
        }
    }

    @org.junit.Test
    public void testListFilesAndDirectories() throws Exception {
        FileManager fileManager = new FileManager();
        File file = new File(fileManager.printWorkingDirectory());
        String[] files = file.list();
        String list = fileManager.listFilesAndDirectories();

        for (int i = 0; i < files.length; i++){
            assertTrue(list.contains(files[i]));
        }
    }
}