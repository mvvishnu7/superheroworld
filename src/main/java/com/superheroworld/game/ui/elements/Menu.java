package com.superheroworld.game.ui.elements;

    import java.util.List;

public interface Menu extends UserInterfaceElement<MenuItem> {
    boolean isBackOptionEnabled();

    void setBackOptionEnabled(boolean backOptionEnabled);

    boolean isSaveOptionEnabled();

    void setSaveOptionEnabled(boolean saveOptionEnabled);

    List<MenuItem> getMenuItems();

    void setMenuItems(List<MenuItem> menuItems);
}
