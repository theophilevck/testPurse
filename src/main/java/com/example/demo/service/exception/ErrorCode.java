package com.example.demo.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_REQUEST(HttpStatus.BAD_REQUEST),
    UNHANDLED(HttpStatus.INTERNAL_SERVER_ERROR),
    SYSTEM_NOT_AUTHORIZED(HttpStatus.FORBIDDEN),

    REFRESH_TOKEN_EXPIRED(HttpStatus.BAD_REQUEST),
    ACCESS_TOKEN_EXPIRED(HttpStatus.BAD_REQUEST),
    INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST),
    INVALID_ACCESS_TOKEN(HttpStatus.BAD_REQUEST);

    private final HttpStatus httpStatus;
}
