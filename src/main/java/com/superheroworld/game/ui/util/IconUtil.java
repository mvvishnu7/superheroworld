package com.superheroworld.game.ui.util;

import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;
import com.superheroworld.game.ui.elements.IconInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.superheroworld.game.ui.util.TerminalDisplayUtil.combine2dArrayHorizontally;
import static com.superheroworld.game.ui.util.TerminalDisplayUtil.print2dArray;

public class IconUtil {

    private static Logger LOG = Logger.getLogger(IconUtil.class.getName());

    private IconUtil() {
    }

    public static String getIconRelativePath(String fileName) {
        return "icons" + File.separator + fileName;
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

    private static char[][] loadIconFromFile(String fileName, String label)
            throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException {
        char[][] myArray;
        List<String> fileData = new LinkedList<>();
        int maxColLength = 0;
        try (InputStream inputStream = IconUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                fileData.add(currentLine);
            }

            int lineCount = fileData.size();
            int rowCount = label != null ? lineCount + 1 : lineCount;

            myArray = new char[Math.toIntExact(rowCount)][];

            // Loads icon by line and calculates the max col length
            for (int row = 0; row < lineCount; row++) {
                myArray[row] = fileData.get(row).toCharArray();
                if (maxColLength < myArray[row].length) {
                    maxColLength = myArray[row].length;
                }
            }

            if (isInvalidIconDimension(maxColLength)) {
                LOG.log(Level.SEVERE, "Please set max width of impl(" + fileName + ") as a even number. Current length: " + maxColLength);
                throw new IconDimensionUnCheckedException("Please set max width of impl(" + fileName + ") as a even number. Current length: " + maxColLength);
            }

            addLabelToArray(label, myArray, maxColLength);
        } catch (NullPointerException exception) {
            LOG.log(Level.SEVERE, "Icon file - " + fileName + "Not found", exception.getCause());
            throw new IconNotFoundUnCheckedException("Icon file - " + fileName + "Not found");
        } catch (IOException exception) {
            LOG.log(Level.SEVERE, "Error while reading icon -" + fileName, exception.getCause());
            throw new IconReadUnCheckedException("Error while reading icon -" + fileName);
        }
        return myArray;
    }

    private static void addLabelToArray(String label, char[][] myArray, int maxColLength) {
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
            myArray[myArray.length - 1] = label.toCharArray();
        }
    }

    private static boolean isInvalidIconDimension(int maxColLength) {
        return maxColLength % 2 != 0;
    }
}
