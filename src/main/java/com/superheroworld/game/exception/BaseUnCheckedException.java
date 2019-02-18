package com.superheroworld.game.exception;

/**
 * Base unchecked exception for the game
 */
public class BaseUnCheckedException extends RuntimeException {

    BaseUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    BaseUnCheckedException(String message) {
        super(message);
    }
}
