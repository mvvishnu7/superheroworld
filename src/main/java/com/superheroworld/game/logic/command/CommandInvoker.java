package com.superheroworld.game.logic.command;

public class CommandInvoker {

    /**
     * Invokes the command corresponding to the commandType
     *
     * @param commandType
     */
    public static void executeCommand(CommandType commandType) {
        CommandFactory.getCommand(commandType).execute();
    }
}
