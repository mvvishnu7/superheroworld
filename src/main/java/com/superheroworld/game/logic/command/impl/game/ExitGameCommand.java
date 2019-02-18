package com.superheroworld.game.logic.command.impl.game;

import java.util.Collections;

import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

public class ExitGameCommand extends AbstractCommand {

    public ExitGameCommand() {
        super(CommandType.EXITGAME);
    }

    public void execute() {
        UserInterface userInterface = new DefaultUserInterfaceHandler();
        userInterface.printMessage(Collections.singletonList("THANK YOU FOR PLAYING 'SUPER HERO WORLD' "));
        getContext().setNextCommandType(null);
    }
}
