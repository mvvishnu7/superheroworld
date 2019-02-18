package com.superheroworld.game.ui.elements;

public interface MenuItem {
    void setIconInfo(IconInfo iconInfo);

    IconInfo getIconInfo();

    String getValue();

    void setValue(String text);

    String getSelectionValue();

    void setSelectionValue(String value);
}
