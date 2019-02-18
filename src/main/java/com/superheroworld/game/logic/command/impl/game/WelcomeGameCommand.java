package com.superheroworld.game.logic.command.impl.game;

import java.util.Collections;

import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;
import com.superheroworld.game.ui.util.IconUtil;

import static com.superheroworld.game.logic.command.CommandType.STARTGAME;
import static com.superheroworld.game.logic.command.CommandType.WELCOME;

public class WelcomeGameCommand extends AbstractCommand {

    public WelcomeGameCommand() {
        super(WELCOME);
    }

    @Override
    public void execute() {
        UserInterface userInterface = new DefaultUserInterfaceHandler();

        String filePath = IconUtil.getIconRelativePath("welcome.txt");

        IconInfo welcomeIcon = new IconInfo();
        welcomeIcon.setRelativePath(filePath);

        userInterface.printIconHorizontally(Collections.singletonList(welcomeIcon), 1);
        getContext().setNextCommandType(STARTGAME);

    }
}
