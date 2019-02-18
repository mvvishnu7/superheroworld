package com.superheroworld.game.exception;

/**
 * Invalid Command Value Exception
 */
public class InvalidCommandValueException extends BaseUnCheckedException {
    public InvalidCommandValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCommandValueException(String message) {
        super(message);
    }
}
