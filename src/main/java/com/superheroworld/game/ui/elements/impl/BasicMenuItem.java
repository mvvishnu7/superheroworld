package com.superheroworld.game.ui.elements.impl;

import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.IconInfo;

public class BasicMenuItem implements MenuItem {

    private String value;
    private String selectionValue;
    private IconInfo iconInfo;

    @Override
    public IconInfo getIconInfo() {
        return iconInfo;
    }

    @Override
    public void setIconInfo(IconInfo iconInfo) {
        this.iconInfo = iconInfo;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String text) {
        this.value = text;
    }

    @Override
    public String getSelectionValue() {
        return selectionValue;
    }

    @Override
    public void setSelectionValue(String value) {
        this.selectionValue = value;
    }
}
