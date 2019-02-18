package com.superheroworld.game.ui.elements.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;
import com.superheroworld.game.exception.InvalidUserInputException;
import com.superheroworld.game.ui.elements.AbstractUserInterfaceElement;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.elements.Menu;
import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.UserInterface;

import static com.superheroworld.game.ui.elements.UserInterfaceType.MENU;
import static com.superheroworld.game.ui.util.MenuUtil.getBackMenu;
import static com.superheroworld.game.ui.util.MenuUtil.getExitMenu;
import static com.superheroworld.game.ui.util.MenuUtil.getSaveMenu;

public class BasicMenu extends AbstractUserInterfaceElement<MenuItem> implements Menu {

    private static final String SELECT_PROMPT = "\nPlease select from below choices by choosing the corresponding number";
    private static final String CHOICE_PROMPT = "\nYour Choice: ";
    private MenuItem selectedMenuItem;
    private List<MenuItem> menuItems;
    private boolean backOptionEnabled;
    private boolean saveOptionEnabled;

    public BasicMenu() {
        super(MENU);
        menuItems = new ArrayList<>();
    }


    public boolean isBackOptionEnabled() {
        return backOptionEnabled;
    }

    public void setBackOptionEnabled(boolean backOptionEnabled) {
        this.backOptionEnabled = backOptionEnabled;
    }

    public boolean isSaveOptionEnabled() {
        return saveOptionEnabled;
    }

    public void setSaveOptionEnabled(boolean saveOptionEnabled) {
        this.saveOptionEnabled = saveOptionEnabled;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems.addAll(menuItems);
        addBackAndExit();
    }

    @Override
    public MenuItem getUserResponse() {
        return selectedMenuItem;
    }

    @Override
    public void displayArgument(UserInterface userInterface)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException {
        getTerminal().writeNewLine(SELECT_PROMPT);
        List<IconInfo> iconInfoList = new ArrayList<>();
        menuItems.forEach(menuItem -> {
            iconInfoList.add(menuItem.getIconInfo());
        });

        userInterface.printIconHorizontally(iconInfoList, 1);

        getTerminal().writeNewLine(CHOICE_PROMPT);
        getTerminal().lineBreak();
    }

    @Override
    public void handleUserResponse(String userResponse) throws InvalidUserInputException {
        Optional.ofNullable(userResponse).ifPresent(
            response -> this.selectedMenuItem = menuItems.stream().filter(
                menuItem -> menuItem.getSelectionValue().equalsIgnoreCase(userResponse))
                .findAny().orElse(null));
        Optional.ofNullable(this.selectedMenuItem)
            .orElseThrow(() -> new InvalidUserInputException("Invalid selection on menu"));
    }


    private void addBackAndExit() {
        if (isBackOptionEnabled()) {
            getMenuItems().add(getBackMenu());
        }

        if (isSaveOptionEnabled()) {
            getMenuItems().add(getSaveMenu());
        }

        getMenuItems().add(getExitMenu());
    }
}
