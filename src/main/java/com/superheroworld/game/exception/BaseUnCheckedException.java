package com.superheroworld.game.exception;

//
public class BaseUnCheckedException extends RuntimeException {

    BaseUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    BaseUnCheckedException(String message) {
        super(message);
    }
}
