package com.superheroworld.game.data.dao;

import com.superheroworld.game.commons.util.FileUtil;
import com.superheroworld.game.data.model.ApplicationState;

/**
 * Handle's operations on Application state
 */
public class ApplicationStateDao {
    private static String fileName = "Game_State.ser";

    /**
     * Save's Application state in a file
     *
     * @param state
     */
    public void save(ApplicationState state) {
        FileUtil.writeToFile(state, fileName);
    }

    /**
     * Load's Application state from a file
     *
     * @return
     */
    public ApplicationState load() {
        return (ApplicationState) FileUtil.readFromFile(fileName);
    }
}
