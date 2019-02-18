package com.superheroworld.game.logic.command;

public class CommandInvoker {

    public static void executeCommand(CommandType commandType) {
        CommandFactory.getCommand(commandType).execute();
    }
}
