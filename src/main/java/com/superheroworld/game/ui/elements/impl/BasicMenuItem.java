package com.superheroworld.game.ui.elements.impl;

import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.IconInfo;

public class BasicMenuItem implements MenuItem {

    private String text;
    private String value;
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
        return text;
    }

    @Override
    public void setValue(String text) {
        this.text = text;
    }

    @Override
    public String getSelectionValue() {
        return value;
    }

    @Override
    public void setSelectionValue(String value) {
        this.value = value;
    }
}
