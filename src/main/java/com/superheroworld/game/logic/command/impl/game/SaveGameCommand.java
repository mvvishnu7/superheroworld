package com.superheroworld.game.logic.command.impl.game;

import java.util.Collections;

import com.superheroworld.game.data.dao.ApplicationStateDao;
import com.superheroworld.game.data.mapper.ContextApplicationStateMapper;
import com.superheroworld.game.data.model.ApplicationState;
import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

public class SaveGameCommand extends AbstractCommand {
    public SaveGameCommand() {
        super(CommandType.SAVEGAME);
    }

    @Override
    public void execute() {
        UserInterface userInterface = new DefaultUserInterfaceHandler();
        userInterface.printMessage(Collections.singletonList("Saving game ......."));

        ApplicationState currentState = ContextApplicationStateMapper.makeApplicationState(getContext());

        //implement dao
        ApplicationStateDao dao = new ApplicationStateDao();
        dao.save(currentState);

        userInterface.printMessage(Collections.singletonList("Saved game successfully......."));

        getContext().setNextCommandType(CommandType.EXITGAME);
    }
}
