package com.superheroworld.game.ui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.superheroworld.game.commons.util.FileUtil;
import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.terminal.Terminal;
import com.superheroworld.game.ui.terminal.impl.DefaultTerminal;

public class IconUtil {

    private static Logger LOG = Logger.getLogger(IconUtil.class.getName());

    private static final Terminal TERMINAL = DefaultTerminal.getInstance();

    public static String getIconRelativePath(String fileName) {
        return File.separator + "icons"
            + File.separator + fileName;
    }

    public static void displayIcons(List<IconInfo> iconInfoList)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException {
        List<char[][]> loadedIcons = new ArrayList<>();

        if (iconInfoList != null) {
            iconInfoList.forEach(iconInfo -> {
                if (iconInfo != null) {
                    loadedIcons.add(loadIconFromFile(iconInfo.getRelativePath(), iconInfo.getLabel()));
                }
            });
            char[][] mergedIcons = loadedIcons.get(0);
            if (loadedIcons.size() > 1) {
                for (int i = 1; i < loadedIcons.size(); i++) {
                    mergedIcons = combine2dArrayHorizontally(mergedIcons, loadedIcons.get(i));
                }
            }

            print2dArray(mergedIcons);
        }
    }

    private static char[][] combine2dArrayHorizontally(char[][] arr1, char[][] arr2) {
        int rowCount = arr1.length > arr2.length ? arr1.length : arr2.length;

        char[][] mergedArr = new char[rowCount][];
        for (int i = 0; i < mergedArr.length; i++) {

            StringBuilder a1row = new StringBuilder();
            StringBuilder a2row = new StringBuilder();
            if (arr1.length <= i) {
                a2row = new StringBuilder(String.valueOf(arr2[i]));
                for (int j = 0; j < a2row.length(); j++) {
                    a1row.append(" ");
                }
            } else if (arr2.length <= i) {
                a1row = new StringBuilder(String.valueOf(arr1[i]));
                for (int j = 0; j < a1row.length(); j++) {
                    a2row.append(" ");
                }
            } else {
                a1row = new StringBuilder(String.valueOf(arr1[i]));
                a2row = new StringBuilder(String.valueOf(arr2[i]));
            }

            mergedArr[i] = (a1row + a2row.toString()).toCharArray();
        }
        return mergedArr;
    }

    private static void print2dArray(char[][] data) {
        for (char[] x : data) {
            for (char y : x) {
                TERMINAL.write(y + " ");
            }
            TERMINAL.lineBreak();
        }
    }

    private static char[][] loadIconFromFile(String fileName, String label)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException {

        char[][] myArray = null;

        try {
            int maxColLength = 0;
            String absolutePath = FileUtil.getAbsoluteFilePath(fileName);
            File file = new File(absolutePath);
            int lineCount = getLineCount(file);

            int rowCount = label != null ? lineCount + 1 : lineCount;
            myArray = new char[Math.toIntExact(rowCount)][];

            maxColLength = getMaxColLength(myArray, maxColLength, file, lineCount);

            if (maxColLength % 2 != 0) {
                LOG.log(Level.SEVERE, "Please set max width of impl(" + fileName + ") as a even number. Current length: " + maxColLength);
                throw new IconDimensionUnCheckedException("Please set max width of impl(" + fileName + ") as a even number. Current length: " + maxColLength);
            }

            if (label != null && maxColLength > label.length()) {
                int spaceCount = ((maxColLength - label.length()) / 2);
                StringBuilder labelBuilder = new StringBuilder(label);
                for (int i = 0; i < spaceCount; i++) {
                    labelBuilder = new StringBuilder(" " + labelBuilder + " ");
                }
                if (labelBuilder.toString().length() != maxColLength) {
                    labelBuilder.append(" ");
                }
                label = labelBuilder.toString();
                myArray[lineCount] = label.toCharArray();
            }
        } catch (FileNotFoundException exception) {
            LOG.log(Level.SEVERE, "Icon file - " + fileName + "Not found", exception.getCause());
            throw new IconNotFoundUnCheckedException("Icon file - " + fileName + "Not found");
        } catch (IOException exception) {
            LOG.log(Level.SEVERE, "Error while reading icon -" + fileName, exception.getCause());
            throw new IconReadUnCheckedException("Error while reading icon -" + fileName);
        }
        return myArray;
    }

    private static int getLineCount(File file) throws IOException {
        return Math.toIntExact(Files.lines(file.toPath()).count());
    }

    private static int getMaxColLength(char[][] myArray, int maxColLength, File file, int lineCount) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(file)) {
            for (int row = 0; scanner.hasNextLine() && row < lineCount; row++) {
                myArray[row] = scanner.nextLine().toCharArray();
                if (maxColLength < myArray[row].length) {
                    maxColLength = myArray[row].length;
                }
            }
        }
        return maxColLength;
    }
}
