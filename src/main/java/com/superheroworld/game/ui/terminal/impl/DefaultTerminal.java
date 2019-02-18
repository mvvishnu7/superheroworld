package com.superheroworld.game.ui.terminal.impl;

import java.util.Scanner;

import com.superheroworld.game.ui.terminal.Terminal;

public final class DefaultTerminal implements Terminal {
    private Scanner scanner;
    private static Terminal INSTANCE;

    private DefaultTerminal() {
        scanner = new Scanner(System.in);
    }

    public static Terminal getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DefaultTerminal();
        }
        return INSTANCE;
    }

    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public void writeNewLine(String message) {
        System.out.println(message);
    }

    @Override
    public void lineBreak() {
        System.out.println();
    }
}
