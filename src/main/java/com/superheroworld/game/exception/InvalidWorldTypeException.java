package com.superheroworld.game.exception;

/**
 * Invalid World type exception
 */
public class InvalidWorldTypeException extends BaseUnCheckedException {
    public InvalidWorldTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidWorldTypeException(String message) {
        super(message);
    }
}
