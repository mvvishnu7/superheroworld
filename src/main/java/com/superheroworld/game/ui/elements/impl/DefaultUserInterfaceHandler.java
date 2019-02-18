package com.superheroworld.game.ui.elements.impl;

import java.util.Collections;
import java.util.List;

import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;
import com.superheroworld.game.exception.InvalidUserInputException;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.UserInterfaceElement;
import com.superheroworld.game.ui.terminal.Terminal;
import com.superheroworld.game.ui.terminal.impl.DefaultTerminal;
import com.superheroworld.game.ui.util.IconUtil;

import static com.superheroworld.game.commons.Constants.INVALID_RESPONSE_PROMPT;

public class DefaultUserInterfaceHandler implements UserInterface {

    private Terminal terminal;
    private List<UserInterfaceElement> userUserInterfaceElements;

    public DefaultUserInterfaceHandler() {
        terminal = DefaultTerminal.getInstance();
    }

    public void setUserUserInterfaceElements(List<UserInterfaceElement> userUserInterfaceElements) {
        this.userUserInterfaceElements = userUserInterfaceElements;
    }

    @Override
    public void printMessage(List<String> messages) {
        messages.forEach(terminal::writeNewLine);
    }

    @Override
    public List<UserInterfaceElement> readUserInterfaceElementsFromUser() {
        userUserInterfaceElements.forEach(userInterfaceElement -> {
            boolean isResponseRead = false;
            userInterfaceElement.displayArgument(this);
            while (!isResponseRead) {
                try {
                    userInterfaceElement.handleUserResponse(terminal.read());
                    isResponseRead = true;
                } catch (InvalidUserInputException e) {
                    printMessage(Collections.singletonList(INVALID_RESPONSE_PROMPT));
                }
            }
        });

        return userUserInterfaceElements;
    }

    @Override
    public void printIconHorizontally(List<IconInfo> icons)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException {
        IconUtil.displayIcons(icons);
    }
}
