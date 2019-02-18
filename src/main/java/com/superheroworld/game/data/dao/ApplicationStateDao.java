package com.superheroworld.game.data.dao;

import com.superheroworld.game.commons.util.FileUtil;
import com.superheroworld.game.data.model.ApplicationState;

public class ApplicationStateDao {
    private static String fileName = "Game_State.ser";

    public void save(ApplicationState state) {
        FileUtil.writeToFile(state, fileName);
    }

    public ApplicationState load() {
        return (ApplicationState) FileUtil.readFromFile(fileName);
    }
}
