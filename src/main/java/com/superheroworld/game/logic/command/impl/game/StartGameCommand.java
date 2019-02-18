package com.superheroworld.game.logic.command.impl.game;

import java.util.Arrays;
import java.util.Collections;

import com.superheroworld.game.commons.util.CommandUtil;
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

import static com.superheroworld.game.commons.Constants.MENU_ITEM_ENTER_KEY;
import static com.superheroworld.game.commons.Constants.PAGE_SEPARATOR;
import static com.superheroworld.game.logic.command.CommandType.LOADGAME;
import static com.superheroworld.game.logic.command.CommandType.NEWGAME;
import static com.superheroworld.game.logic.command.CommandType.STARTGAME;

/**
 * Handles Game Start operation
 */
public class StartGameCommand extends AbstractCommand {
    public StartGameCommand() {
        super(STARTGAME);
    }

    @Override
    public void execute() {
        UserInterface userInterface = new DefaultUserInterfaceHandler();
        Menu startMenu = createStartMenu();
        userInterface.setUserUserInterfaceElements(Collections.singletonList(startMenu));

        MenuItem selectedMenuItem = (MenuItem) userInterface
            .readUserInterfaceElementsFromUser()
            .get(0)
            .getUserResponse();

        if (CommandUtil.isDefaultCommand(selectedMenuItem.getValue())) {
            CommandUtil.handleDefaultCommand(selectedMenuItem.getValue());
        } else {
            CommandType next = CommandType.valueOf(selectedMenuItem.getValue());
            getContext().setNextCommandType(next);
        }

        userInterface.printMessage(Collections.singletonList(PAGE_SEPARATOR));
    }

    private Menu createStartMenu() {

        Menu basicMenu = new BasicMenu();

        // New Game
        String newGameFilePath = IconUtil.getIconRelativePath("new_game.txt");
        MenuItem newGameMenuItem = new BasicMenuItem();
        newGameMenuItem.setSelectionValue("0");
        newGameMenuItem.setValue(NEWGAME.toString());
        IconInfo newGameIcon = new IconInfo();
        newGameIcon.setLabel(MENU_ITEM_ENTER_KEY + newGameMenuItem.getSelectionValue());
        newGameIcon.setRelativePath(newGameFilePath);
        newGameMenuItem.setIconInfo(newGameIcon);


        // Load Game
        String loadGameFilePath = IconUtil.getIconRelativePath("load_game.txt");
        MenuItem loadGameMenuItem = new BasicMenuItem();
        loadGameMenuItem.setSelectionValue("1");
        loadGameMenuItem.setValue(LOADGAME.toString());
        IconInfo loadGameIcon = new IconInfo();
        loadGameIcon.setLabel(MENU_ITEM_ENTER_KEY + loadGameMenuItem.getSelectionValue());
        loadGameIcon.setRelativePath(loadGameFilePath);
        loadGameMenuItem.setIconInfo(loadGameIcon);

        //Add menu items to menu
        basicMenu.setMenuItems(Arrays.asList(newGameMenuItem, loadGameMenuItem));

        return basicMenu;
    }
}
