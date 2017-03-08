package com.github.vlshat.epam.unit05.task01;


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
    public String pwd(){
        return currentPath.toString();
    }


    /**
     *
     * @param dir -
     */
    public void cd(String dir){
        if (new File(currentPath.toString() + dir).exists()){
            currentPath.append(dir).append(fileSeparator);
        } else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("such directory doesn't exist");
            }
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
    public String ls(){
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
    public String cat(String fileName){
        try {
            FileReader fileReader = new FileReader(currentPath + fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder result = new StringBuilder();

            while (true){
                String s = reader.readLine();

                if (s == null)
                    break;

                result.append(s).append("\n");
            }

            result.deleteCharAt(result.length() - 1);

            return result.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Something went bad";
    }

    /**
     * Creates new file with text
     * @param fileName
     * @param text
     */
    public void touch(String fileName, String text){
        File file = new File(currentPath + fileName);
        if (file.exists()){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("File already exists");
            }
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

    public void touch(String fileName){
        File file = new File(currentPath + fileName);
        if (file.exists()){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("File already exists");
            }
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
     */
    public void delete(String fileName){
        File file = new File(currentPath + fileName);

        if (!file.exists()){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("Such file doesn't exist");
            }
        } else {
            file.delete();
        }
    }

    /**
     * Creates new directory in current path
     * @param dirName
     */
    public void mkdir(String dirName){
        File file = new File(currentPath + fileSeparator + dirName);
        if (file.exists()){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("Such directory exists");
            }
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
