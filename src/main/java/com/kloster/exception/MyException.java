package com.kloster.exception;

import lombok.Getter;

@Getter
public class MyException extends RuntimeException {

    public MyException(final String message) {
        super(message);
    }
}
