package com.superheroworld.game.logic.command;

import com.superheroworld.game.Context;

/**
 * Abstract class for commands
 */
public abstract class AbstractCommand implements Command {
    private CommandType commandType;
    private Context context;

    public AbstractCommand(CommandType commandType) {
        this.commandType = commandType;
        this.context = Context.getInstance();
    }

    /**
     * Returns the commandType
     *
     * @return CommandType
     */
    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    /**
     * Returns current context
     *
     * @return Context
     */
    protected Context getContext() {
        return context;
    }
}
