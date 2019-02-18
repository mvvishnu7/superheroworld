package com.superheroworld.game.ui.util;

import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.impl.BasicMenuItem;

import static com.superheroworld.game.commons.Constants.BACK_GAME_KEY;
import static com.superheroworld.game.commons.Constants.BACK_GAME_VALUE;
import static com.superheroworld.game.commons.Constants.EXIT_GAME_KEY;
import static com.superheroworld.game.commons.Constants.EXIT_GAME_VALUE;
import static com.superheroworld.game.commons.Constants.MENU_ITEM_ENTER_KEY;
import static com.superheroworld.game.commons.Constants.SAVE_GAME_KEY;
import static com.superheroworld.game.commons.Constants.SAVE_GAME_VALUE;
import static com.superheroworld.game.ui.util.IconUtil.getIconRelativePath;

public class MenuUtil {

    private static final MenuItem BACK_MENU = createBackMenu();
    private static final MenuItem EXIT_MENU = createExitMenu();
    private static final MenuItem SAVE_MENU = createSaveMenu();

    public static MenuItem getBackMenu() {
        return BACK_MENU;
    }

    public static MenuItem getExitMenu() {
        return EXIT_MENU;
    }

    public static MenuItem getSaveMenu() {
        return SAVE_MENU;
    }

    private static MenuItem createBackMenu() {
        String backFilePath = getIconRelativePath("back_game.txt");

        MenuItem backMenuItem = new BasicMenuItem();
        backMenuItem.setValue(BACK_GAME_VALUE);
        backMenuItem.setSelectionValue(BACK_GAME_KEY);
        IconInfo backGameIcon = new IconInfo();
        backGameIcon.setLabel(MENU_ITEM_ENTER_KEY + backMenuItem.getSelectionValue());
        backGameIcon.setRelativePath(backFilePath);

        backMenuItem.setIconInfo(backGameIcon);
        return backMenuItem;
    }

    private static MenuItem createSaveMenu() {
        String saveFilePath = getIconRelativePath("save_game.txt");

        MenuItem saveMenuItem = new BasicMenuItem();
        saveMenuItem.setValue(SAVE_GAME_VALUE);
        saveMenuItem.setSelectionValue(SAVE_GAME_KEY);

        IconInfo saveGameIcon = new IconInfo();
        saveGameIcon.setLabel(MENU_ITEM_ENTER_KEY + saveMenuItem.getSelectionValue());
        saveGameIcon.setRelativePath(saveFilePath);

        saveMenuItem.setIconInfo(saveGameIcon);
        return saveMenuItem;
    }

    private static MenuItem createExitMenu() {
        String exitFilePath = getIconRelativePath("exit_game.txt");

        MenuItem exitMenuItem = new BasicMenuItem();
        exitMenuItem.setValue(EXIT_GAME_VALUE);
        exitMenuItem.setSelectionValue(EXIT_GAME_KEY);
        IconInfo exitGameIcon = new IconInfo();
        exitGameIcon.setLabel(MENU_ITEM_ENTER_KEY + exitMenuItem.getSelectionValue());
        exitGameIcon.setRelativePath(exitFilePath);

        exitMenuItem.setIconInfo(exitGameIcon);
        return exitMenuItem;
    }
}
