package com.github.vlshat.epam.unit05.task01;


import java.io.*;

/**
 * Created by vladislav on 08.03.17.
 */
public class FileManager {

    //private String currentPath = "";
    private StringBuilder currentPath = new StringBuilder(new File("").getAbsolutePath());
    private String fileSeparator = System.getProperty("file.separator");

    public String pwd(){
        return currentPath.toString();
    }


    public void cd(String dir){
        if (new File(currentPath.toString() + fileSeparator + dir).exists()){
            currentPath.append(fileSeparator).append(dir);
        } else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("such directory doesn't exist");
            }
        }
    }

    public void cdB(){
        currentPath.delete(currentPath.lastIndexOf(fileSeparator), currentPath.length());
    }

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

    public String cat(String fileName){
        try {
            FileReader fileReader = new FileReader(currentPath + fileSeparator + fileName);
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

    public String edit(String fileName, String text){
        return null;
    }

    public void touch(String fileName, String text){

    }

    public void delete(String fileName){

    }
}
