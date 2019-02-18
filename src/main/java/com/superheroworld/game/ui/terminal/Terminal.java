package com.superheroworld.game.ui.terminal;

public interface Terminal {
    String read();
    void write(String message);
    void writeNewLine(String message);
    void lineBreak();
}
