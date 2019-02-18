package com.superheroworld.game.logic.command.impl.game;

import java.util.Collections;

import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.data.model.player.impl.DefaultPlayer;
import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.BasicQuery;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static com.superheroworld.game.commons.Constants.PAGE_SEPARATOR;
import static com.superheroworld.game.logic.command.CommandType.NEWGAME;
import static com.superheroworld.game.logic.command.CommandType.SELECTWORLD;

/**
 * Handles New Game operation
 */
public class NewGameCommand extends AbstractCommand {

    public NewGameCommand() {
        super(NEWGAME);
    }

    public void execute() {
        if (getContext().getPlayer() == null) {
            BasicQuery query = new BasicQuery();
            query.setQuery("Please enter the player name");

            UserInterface userInterface = new DefaultUserInterfaceHandler();
            userInterface.setUserUserInterfaceElements(Collections.singletonList(query));

            String playerName = null;
            playerName = (String) userInterface
                .readUserInterfaceElementsFromUser()
                .get(0)
                .getUserResponse();
            Player player = new DefaultPlayer(playerName);
            getContext().setPlayer(player);
            getContext().setNextCommandType(SELECTWORLD);
            userInterface.printMessage(Collections.singletonList(PAGE_SEPARATOR));
        } else {
            getContext().setNextCommandType(SELECTWORLD);
        }
    }
}
