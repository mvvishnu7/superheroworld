package com.superheroworld.game.logic.command;

import com.superheroworld.game.logic.command.impl.game.ExitGameCommand;
import com.superheroworld.game.logic.command.impl.game.LoadGameCommand;
import com.superheroworld.game.logic.command.impl.game.NewGameCommand;
import com.superheroworld.game.logic.command.impl.game.SaveGameCommand;
import com.superheroworld.game.logic.command.impl.game.StartGameCommand;
import com.superheroworld.game.logic.command.impl.game.WelcomeGameCommand;
import com.superheroworld.game.logic.command.impl.opponent.FightOpponentCommand;
import com.superheroworld.game.logic.command.impl.world.SelectOpponentCommand;
import com.superheroworld.game.logic.command.impl.world.SelectWorldCommand;

/**
 * Handles Command Object creation
 */
public class CommandFactory {
    public static Command getCommand(CommandType commandType) {
        switch (commandType) {
            case WELCOME:
                return new WelcomeGameCommand();
            case NEWGAME:
                return new NewGameCommand();
            case STARTGAME:
                return new StartGameCommand();
            case EXITGAME:
                return new ExitGameCommand();
            case LOADGAME:
                return new LoadGameCommand();
            case FIGHT:
                return new FightOpponentCommand();
            case SELECTWORLD:
                return new SelectWorldCommand();
            case SELECTOPPONENTS:
                return new SelectOpponentCommand();
            case SAVEGAME:
                return new SaveGameCommand();
        }

        //TODO create Custom Exception
        throw new Error("INVALID Command !!!");
    }
}
