package com.superheroworld.game.command.util;

import org.junit.Test;

import com.superheroworld.game.Context;
import com.superheroworld.game.commons.util.CommandUtil;
import com.superheroworld.game.exception.InvalidCommandValueException;
import com.superheroworld.game.logic.command.CommandType;

import junit.framework.TestCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static com.superheroworld.game.commons.Constants.EXIT_GAME_VALUE;
import static com.superheroworld.game.commons.Constants.SAVE_GAME_VALUE;

import static junit.framework.TestCase.assertEquals;

public class CommandUtilTest {

    @Test
    public void testValidIsDefaultCommands() {
        assertTrue(CommandUtil.isDefaultCommand(EXIT_GAME_VALUE));
        assertTrue(CommandUtil.isDefaultCommand(SAVE_GAME_VALUE));
    }

    @Test
    public void testInValidIsDefaultCommands() {
        assertFalse(CommandUtil.isDefaultCommand("INVALID"));
    }

    @Test
    public void testHandleDefaultCommandSuccess() {
        CommandUtil.handleDefaultCommand(EXIT_GAME_VALUE);
        TestCase.assertEquals(CommandType.EXITGAME, Context.getInstance().getNextCommandType());

        CommandUtil.handleDefaultCommand(SAVE_GAME_VALUE);
        assertEquals(CommandType.SAVEGAME, Context.getInstance().getNextCommandType());
    }

    @Test(expected = InvalidCommandValueException.class)
    public void testHandleDefaultCommandFailure() {
        CommandUtil.handleDefaultCommand("Invalid");
        assertEquals(CommandType.EXITGAME, Context.getInstance().getNextCommandType());
    }
}
