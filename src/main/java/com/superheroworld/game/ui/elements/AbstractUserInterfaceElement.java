package com.superheroworld.game.ui.elements;

import com.superheroworld.game.ui.terminal.Terminal;
import com.superheroworld.game.ui.terminal.impl.DefaultTerminal;

public abstract class AbstractUserInterfaceElement<T> implements UserInterfaceElement<T> {
    private UserInterfaceType userInterfaceType;
    private Terminal terminal;

    public AbstractUserInterfaceElement(UserInterfaceType userInterfaceType) {
        this.userInterfaceType = userInterfaceType;
        this.terminal = DefaultTerminal.getInstance();
    }

    @Override
    public UserInterfaceType getUserInterfaceType() {
        return userInterfaceType;
    }

    @Override
    public void setUserInterfaceType(UserInterfaceType userInterfaceType) {
        this.userInterfaceType = userInterfaceType;
    }

    public Terminal getTerminal() {
        return terminal;
    }
}
