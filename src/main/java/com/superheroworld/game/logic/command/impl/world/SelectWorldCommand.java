package com.superheroworld.game.logic.command.impl.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.data.model.world.WorldFactory;
import com.superheroworld.game.data.model.world.WorldType;
import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.BasicMenu;
import com.superheroworld.game.ui.elements.impl.BasicMenuItem;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.util.IconUtil;
import com.superheroworld.game.commons.util.CommandUtil;

import static com.superheroworld.game.commons.Constants.BACK_GAME_VALUE;
import static com.superheroworld.game.logic.command.CommandType.SELECTOPPONENTS;
import static com.superheroworld.game.logic.command.CommandType.SELECTWORLD;
import static com.superheroworld.game.logic.command.CommandType.STARTGAME;
import static com.superheroworld.game.commons.Constants.PAGE_SEPARATOR;

public class SelectWorldCommand extends AbstractCommand {

    public SelectWorldCommand() {
        super(SELECTWORLD);
    }

    @Override
    public void execute() {
        UserInterface userInterface = new DefaultUserInterfaceHandler();
        userInterface.printMessage(Collections.singletonList("\nPlease select world you want to enter"));

        BasicMenu worldMenu = new BasicMenu();
        List<MenuItem> availableWorlds = getAvailableWorlds();
        worldMenu.setBackOptionEnabled(true);
        worldMenu.setSaveOptionEnabled(true);
        worldMenu.setMenuItems(availableWorlds);

        userInterface.setUserUserInterfaceElements(Collections.singletonList(worldMenu));

        MenuItem selectedMenuItem = (MenuItem) userInterface
            .readUserInterfaceElementsFromUser()
            .get(0)
            .getUserResponse();

        if (CommandUtil.isDefaultCommand(selectedMenuItem.getValue())) {
            CommandUtil.handleDefaultCommand(selectedMenuItem.getValue());
        } else if (selectedMenuItem.getValue().equalsIgnoreCase(BACK_GAME_VALUE)) {
            getContext().setNextCommandType(STARTGAME);
        } else {
            WorldType selectedWorldType = WorldType.valueOf(selectedMenuItem.getValue());
            World selectedWorld = WorldFactory.getWorld(selectedWorldType);

            getContext().setCurrentWorld(selectedWorld);
            getContext().setNextCommandType(SELECTOPPONENTS);
        }
        userInterface.printMessage(Collections.singletonList(PAGE_SEPARATOR));
    }

    private List<MenuItem> getAvailableWorlds() {
        List<MenuItem> worlds = new ArrayList<>();

        int selectionValue = 0;
        for (WorldType worldType : WorldType.values()) {
            MenuItem worldMenuItem = new BasicMenuItem();

            worldMenuItem.setValue(String.valueOf(worldType));
            worldMenuItem.setSelectionValue(String.valueOf(selectionValue));

            String iconPath = IconUtil.getIconRelativePath(worldType.toString() + "_world.txt");
            IconInfo iconInfo = new IconInfo();
            iconInfo.setRelativePath(iconPath);
            iconInfo.setLabel("ENTER " + worldMenuItem.getSelectionValue());
            worldMenuItem.setIconInfo(iconInfo);

            worlds.add(worldMenuItem);
            selectionValue++;
        }

        return worlds;
    }
}
