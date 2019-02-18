package com.superheroworld.game.logic.command.impl.game;

import java.util.Arrays;
import java.util.Collections;

import com.superheroworld.game.data.dao.ApplicationStateDao;
import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.data.mapper.ContextApplicationStateMapper;
import com.superheroworld.game.data.model.ApplicationState;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static com.superheroworld.game.logic.command.CommandType.LOADGAME;
import static com.superheroworld.game.commons.Constants.PAGE_SEPARATOR;

public class LoadGameCommand extends AbstractCommand {

    public LoadGameCommand() {
        super(LOADGAME);
    }

    @Override
    public void execute() {
        //implement dao
        ApplicationStateDao dao = new ApplicationStateDao();
        ApplicationState loadedState = dao.load();

        ContextApplicationStateMapper.updateContext(getContext(), loadedState);
        getContext().setNextCommandType(getContext().getPreviousCommandType());

        UserInterface userInterface = new DefaultUserInterfaceHandler();
        userInterface.printMessage(Arrays.asList(
            String.format("Welcome back %s", getContext().getPlayer().getName()),
            String.format("Current experience: %s", getContext().getPlayer().getExperience())
        ));
        userInterface.printMessage(Collections.singletonList(PAGE_SEPARATOR));
    }
}

