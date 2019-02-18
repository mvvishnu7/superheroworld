package com.superheroworld.game.exception;

public class BaseCheckedException extends Exception {
    BaseCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    BaseCheckedException(String message) {
        super(message);
    }
}
