package com.superheroworld.game.ui.util;

import com.superheroworld.game.ui.terminal.Terminal;
import com.superheroworld.game.ui.terminal.impl.DefaultTerminal;

public class TerminalDisplayUtil {
    private static final Terminal TERMINAL = DefaultTerminal.getInstance();

    public static char[][] combine2dArrayHorizontally(char[][] arr1, char[][] arr2) {
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

    public static void print2dArray(char[][] data) {
        for (char[] x : data) {
            for (char y : x) {
                TERMINAL.write(y + " ");
            }
            TERMINAL.lineBreak();
        }
    }
}
