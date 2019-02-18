package com.superheroworld.game;

import java.util.Stack;

import com.superheroworld.game.data.model.ApplicationState;
import com.superheroworld.game.data.model.player.impl.DefaultPlayer;
import com.superheroworld.game.logic.command.CommandType;

public class TestUtil {
    public static ApplicationState getDummyApplicationState() {
        Stack<CommandType> commandTypeStack = new Stack<>();
        commandTypeStack.push(CommandType.STARTGAME);
        ApplicationState.ApplicationStateBuilder applicationStateBuilder =
            new ApplicationState.ApplicationStateBuilder(new DefaultPlayer("Test"),
                CommandType.SELECTWORLD,
                commandTypeStack
            );
        return applicationStateBuilder.build();
    }
}
