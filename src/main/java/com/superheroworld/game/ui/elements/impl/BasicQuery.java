package com.superheroworld.game.ui.elements.impl;

import java.util.Collections;

import com.superheroworld.game.ui.elements.AbstractUserInterfaceElement;
import com.superheroworld.game.ui.elements.UserInterface;

import static com.superheroworld.game.ui.elements.UserInterfaceType.QUERY;

public class BasicQuery extends AbstractUserInterfaceElement<String> {

    private String userResponse;
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public BasicQuery() {
        super(QUERY);
    }

    @Override
    public String getUserResponse() {
        return userResponse;
    }

    public void displayArgument(UserInterface userInterface) {
        if (query != null) {
            userInterface.printMessage(Collections.singletonList(query));
        }
    }

    @Override
    public void handleUserResponse(String response) {
        userResponse = response;
    }
}
