package com.superheroworld.game.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.superheroworld.game.exception.FileReadError;
import com.superheroworld.game.exception.FileWriteError;

public class FileUtil {

    private static final Logger LOG = Logger.getLogger(FileUtil.class.getName());

    public static void writeToFile(Object object, String fileName) throws FileWriteError {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Error occurred while writing file" + fileName, e.getCause());
            throw new FileWriteError("Unable to write to file - " + fileName);
        } finally {
            try {
                assert objectOutputStream != null;
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Error occurred while closing file stream" + fileName, e.getCause());
                throw new FileWriteError("Unable to write to file - " + fileName);
            }
        }
    }

    public static Object readFromFile(String fileName) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileReadError("Unable to read file - " + fileName);
        }
    }

    public static String getAbsoluteFilePath(String relativePath) {
        return getBasePath() + relativePath;
    }

    private static String getBasePath() {
        String filePath = new File("").getAbsolutePath();
        return filePath
            + File.separator + "src"
            + File.separator + "main"
            + File.separator + "resources";
    }
}
