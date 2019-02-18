package com.superheroworld.game.logic.command;

public interface Command {

    CommandType getCommandType();

    void execute();
}
