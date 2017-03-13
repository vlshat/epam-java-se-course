package com.github.vlshat.epam.unit05.task01;

import com.github.vlshat.epam.unit05.task01.Exceptions.DirectoryNotFoundException;
import com.github.vlshat.epam.unit05.task01.Exceptions.FileExistsException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by vladislav on 08.03.17.
 */
public class Test {
    public static void main(String[] args) throws IOException, DirectoryNotFoundException, FileExistsException {
        //System.out.print(System.getProperty("file.separator"));
        FileManager fileManager = new FileManager();
        System.out.println(fileManager.printWorkingDirectory());
        System.out.println(fileManager.listFilesAndDirectories());
//        fileManager.changeDirectory("src");
//        System.out.println(fileManager.printWorkingDirectory());
//        fileManager.changeDirectory("s");
//        fileManager.goToThePreviousDirectory();
//        System.out.println(fileManager.printWorkingDirectory());
//        fileManager.createFile("test.txt", "Blah!");
//        System.out.println(fileManager.getFile("test.txt"));
//        fileManager.delete("aaaaa");
//        fileManager.delete("test.txt");
//        fileManager.createFile("aaaaa", "aaaaaaaaaaa");
//        fileManager.createFile("aaaaa", "aaaaaaaaaaa");
//        File file = new File("");
//        fileManager.addTextToFile("aaaaa", "addedText");
//        fileManager.createFile("blah.txt");
//        fileManager.delete("blah2");
//        System.out.println(fileManager.listFilesAndDirectories());

    }
}
