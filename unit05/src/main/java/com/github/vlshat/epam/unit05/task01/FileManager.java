package com.github.vlshat.epam.unit05.task01;


import com.github.vlshat.epam.unit05.task01.Exceptions.DirectoryNotFoundException;
import com.github.vlshat.epam.unit05.task01.Exceptions.FileExistsException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by vladislav on 08.03.17.
 */
public class FileManager {

    private String fileSeparator = System.getProperty("file.separator");
    private StringBuilder currentPath = new StringBuilder(new File("").getAbsolutePath() + fileSeparator);

    /**
     * Returns current directory
     * @return
     */
    public String printWorkingDirectory(){
        return currentPath.toString();
    }


    /**
     *
     * @param dir -
     * @throws DirectoryNotFoundException
     */
    public void changeDirectory(String dir) throws DirectoryNotFoundException {
        if (new File(currentPath.toString() + dir).exists()){
            currentPath.append(dir).append(fileSeparator);
        } else {
            throw new DirectoryNotFoundException("Such directory doesn't exist");
        }
    }

    /**
     * Returns to the previous directory.
     */
    public void cdB(){
        if (currentPath.lastIndexOf(fileSeparator) == currentPath.indexOf(fileSeparator)){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            currentPath.deleteCharAt(currentPath.length() - 1);
            currentPath.delete(currentPath.lastIndexOf(fileSeparator) + 1, currentPath.length());
        }
    }

    /**
     * @return list of files and directories
     */
    public String listFilesAndDirectories(){

        File file = new File(currentPath.toString());
        String[] filesAndDirectories = file.list();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < filesAndDirectories.length; i++){
            result.append(filesAndDirectories[i]);
            result.append("\n");
        }

        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    /**
     * @param fileName
     * @return
     */
    public String getFile(String fileName){

        StringBuilder result = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentPath + fileName));

            while (true){
                String s = reader.readLine();

                if (s == null)
                    break;

                result.append(s).append("\n");
            }

            result.deleteCharAt(result.length() - 1);

            return result.toString();

        } catch (FileNotFoundException e) {
            return "Such file doesn't exist";
        } catch (IOException e) {
            return result.toString();
        }
    }

    /**
     * Creates new file with text
     * @param fileName
     * @param text
     * @throws FileExistsException
     */
    public void createFile(String fileName, String text) throws FileExistsException {
        File file = new File(currentPath + fileName);
        if (file.exists()){
            throw new FileExistsException("File already exists");
        } else {
            try {
                FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
                fileWriter.write(text);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param fileName
     * @throws FileExistsException
     */
    public void createFile(String fileName) throws FileExistsException {
        File file = new File(currentPath + fileName);
        if (file.exists()){
            throw new FileExistsException("Such file already exists");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Deletes file from current directory
     * @param fileName
     * @throws FileNotFoundException
     */
    public void delete(String fileName) throws FileNotFoundException {

        File file = new File(currentPath + fileName);

        if (!file.exists()){
            throw new FileNotFoundException("Such file already exists");
        } else {
            file.delete();
        }
    }


    /**
     * @param dirName
     * @throws FileExistsException
     */
    public void createDirectory(String dirName) throws FileExistsException {
        File file = new File(currentPath + fileSeparator + dirName);
        if (file.exists()){
            throw new FileExistsException("Such directory exists");
        } else {
            file.mkdir();
        }
    }

    /**
     * Adds a text at the end of the file
     * @param fileName
     * @param text
     */
    public void addTextToFile(String fileName, String text){
        try {
            Files.write(Paths.get(currentPath + fileName), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
