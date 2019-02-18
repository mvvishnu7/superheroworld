package com.superheroworld.game.logic.command;

import com.superheroworld.game.Context;

public abstract class AbstractCommand implements Command {
    private CommandType commandType;
    private Context context;

    public AbstractCommand(CommandType commandType) {
        this.commandType = commandType;
        this.context = Context.getInstance();
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    protected Context getContext() {
        return context;
    }
}
