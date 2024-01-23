package com.example.demo.service.exception;

import java.util.Arrays;

public class DemoException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String[] args;

    public DemoException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.args = null;
    }

    public DemoException(final ErrorCode errorCode,
                         final Object... args) {
        this.errorCode = errorCode;
        this.args = Arrays.stream(args).map(String::valueOf).toArray(String[]::new);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String[] getArgs() {
        return args == null ? null : Arrays.copyOf(args, args.length);
    }
}
