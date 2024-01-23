package com.example.demo.service.exception;


import lombok.Getter;
import org.springframework.web.client.RestClientException;

@Getter
public class DemoRestClientException extends RestClientException {

    private final String error;

    public DemoRestClientException(final String error, final String msg) {
        super(msg);
        this.error = error;
    }




}


