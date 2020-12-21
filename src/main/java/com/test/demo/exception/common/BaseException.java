package com.test.demo.exception.common;

import lombok.Getter;

@Getter
public class BaseException extends Exception {
    private String message;

    public BaseException(String message) {
        this.message = message;
    }
}
