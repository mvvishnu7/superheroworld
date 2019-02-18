package com.superheroworld.game.exception;

/**
 * Base checked exception for the game
 */
public class BaseCheckedException extends Exception {
    BaseCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    BaseCheckedException(String message) {
        super(message);
    }
}
