package com.superheroworld.game.command.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.commons.util.FileUtil;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtil.class)
public class FileUtilTest {

    private FileUtil fileUtil;
    private FileOutputStream mockFileOutputStream;
    private ObjectOutputStream mockObjectOutputStream;
    private ObjectInputStream mockObjectInputStream;
    private File mockFile;
    private String fileName = "testing.ser";

    @Before
    public void setUp() throws Exception {
        mockFileOutputStream = mock(FileOutputStream.class);
        mockObjectOutputStream = mock(ObjectOutputStream.class);
        mockObjectInputStream = mock(ObjectInputStream.class);
        mockFile = mock(File.class);

        PowerMockito.whenNew(FileOutputStream.class)
            .withArguments(fileName).thenReturn(mockFileOutputStream);
        PowerMockito.whenNew(ObjectOutputStream.class)
            .withAnyArguments().thenReturn(mockObjectOutputStream);
        PowerMockito.whenNew(ObjectInputStream.class)
            .withAnyArguments().thenReturn(mockObjectInputStream);
        PowerMockito.whenNew(File.class)
            .withAnyArguments().thenReturn(mockFile);
    }


    @Test
    public void testWriteToFileSuccess() throws IOException {
//        Object object = new Object();
//
//        FileUtil.writeToFile(object, fileName);
//
//        verify(mockObjectOutputStream, times(1)).writeObject(object);
    }

}
