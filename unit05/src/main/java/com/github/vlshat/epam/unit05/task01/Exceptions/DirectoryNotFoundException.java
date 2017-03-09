package com.github.vlshat.epam.unit05.task01.Exceptions;

/**
 * Created by vladislav on 09.03.17.
 */
public class DirectoryNotFoundException extends FileManagerException{
    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
