package com.superheroworld.game.commons.util;

import java.util.Arrays;
import java.util.List;

import com.superheroworld.game.Context;
import com.superheroworld.game.exception.InvalidCommandValueException;

import static com.superheroworld.game.commons.Constants.EXIT_GAME_VALUE;
import static com.superheroworld.game.commons.Constants.SAVE_GAME_VALUE;
import static com.superheroworld.game.logic.command.CommandType.EXITGAME;
import static com.superheroworld.game.logic.command.CommandType.SAVEGAME;

/**
 * Handles command utility operations
 */
public class CommandUtil {

    private static final Context CONTEXT = Context.getInstance();

    private static final List<String> defaultCommands = Arrays.asList(
        EXIT_GAME_VALUE,
        SAVE_GAME_VALUE);

    /**
     * Checks if a user response points to a default command
     *
     * @param commandValue
     * @return
     */
    public static boolean isDefaultCommand(String commandValue) {
        return defaultCommands.contains(commandValue);
    }

    /**
     * Handles default commands
     *
     * @param commandValue
     */
    public static void handleDefaultCommand(String commandValue) {
        switch (commandValue) {
            case EXIT_GAME_VALUE:
                CONTEXT.setNextCommandType(EXITGAME);
                break;
            case SAVE_GAME_VALUE:
                CONTEXT.setNextCommandType(SAVEGAME);
                break;
            default:
                throw new InvalidCommandValueException("Invalid Command Value - " + commandValue);
        }
    }
}
