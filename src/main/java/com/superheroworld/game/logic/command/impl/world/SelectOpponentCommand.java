package com.superheroworld.game.logic.command.impl.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.superheroworld.game.commons.util.CommandUtil;
import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.elements.Menu;
import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.BasicMenu;
import com.superheroworld.game.ui.elements.impl.BasicMenuItem;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;
import com.superheroworld.game.ui.util.IconUtil;

import static com.superheroworld.game.commons.Constants.BACK_GAME_VALUE;
import static com.superheroworld.game.commons.Constants.PAGE_SEPARATOR;

public class SelectOpponentCommand extends AbstractCommand {

    public SelectOpponentCommand() {
        super(CommandType.SELECTOPPONENTS);
    }

    @Override
    public void execute() {
        UserInterface userInterface = new DefaultUserInterfaceHandler();
        userInterface.printMessage(Collections.singletonList("Please select one opponent you dare to opponent !!"));
        Menu worldMenu = new BasicMenu();
        List<MenuItem> availableOpponents = getAvailableOpponents();
        worldMenu.setSaveOptionEnabled(true);
        worldMenu.setBackOptionEnabled(true);
        worldMenu.setMenuItems(availableOpponents);

        userInterface.setUserUserInterfaceElements(Collections.singletonList(worldMenu));

        MenuItem selectedMenuItem = (MenuItem) userInterface
            .readUserInterfaceElementsFromUser()
            .get(0)
            .getUserResponse();

        if (CommandUtil.isDefaultCommand(selectedMenuItem.getValue())) {
            CommandUtil.handleDefaultCommand(selectedMenuItem.getValue());
        } else if (selectedMenuItem.getValue().equalsIgnoreCase(BACK_GAME_VALUE)) {
            getContext().setNextCommandType(CommandType.SELECTWORLD);
        } else {

            Opponent selectedOpponent = null;
            for (Opponent opponent : getContext().getCurrentWorld().getOpponents()) {
                if (opponent.getName().equalsIgnoreCase(selectedMenuItem.getValue())) {
                    selectedOpponent = opponent;
                    break;
                }
            }

            getContext().setCurrentOpponent(selectedOpponent);
            getContext().setNextCommandType(CommandType.FIGHT);
        }
        userInterface.printMessage(Collections.singletonList(PAGE_SEPARATOR));
    }

    private List<MenuItem> getAvailableOpponents() {
        int selectionValue = 0;
        List<MenuItem> opponents = new ArrayList<>();
        World currentWorld = getContext().getCurrentWorld();

        for (Opponent opponent : currentWorld.getOpponents()) {
            MenuItem opponentMenuItem = new BasicMenuItem();

            String iconPath = IconUtil.getIconRelativePath(opponent.getName().replace(' ', '_').toLowerCase() + ".txt");
            opponentMenuItem.setValue(opponent.getName());
            opponentMenuItem.setSelectionValue(String.valueOf(selectionValue));

            IconInfo iconInfo = new IconInfo();
            iconInfo.setRelativePath(iconPath);
            iconInfo.setLabel("ENTER " + opponentMenuItem.getSelectionValue());
            opponentMenuItem.setIconInfo(iconInfo);

            opponents.add(opponentMenuItem);
            selectionValue++;
        }

        return opponents;
    }
}
