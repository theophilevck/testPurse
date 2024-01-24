package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponseDto {
    private List<ErrorDto> errors = new ArrayList<>();

    public List<ErrorDto> getErrors() {
        return errors;
    }

    public ErrorResponseDto setErrors(List<ErrorDto> errors) {
        this.errors = errors;
        return this;
    }

    public ErrorResponseDto addErrorsItem(ErrorDto errorDto) {
        this.errors.add(errorDto);
        return this;
    }
}
