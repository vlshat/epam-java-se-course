package com.github.vlshat.epam.unit05.task01.Exceptions;

import com.github.vlshat.epam.unit05.task01.FileManager;

/**
 * Created by vladislav on 09.03.17.
 */
public class FileExistsException extends FileManagerException {
    public FileExistsException(String message) {
        super(message);
    }
}
