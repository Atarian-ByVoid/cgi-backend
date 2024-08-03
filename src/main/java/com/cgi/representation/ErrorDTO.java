package com.cgi.representation;

import com.cgi.errors.ErrorException;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorDTO {
    int statusCode;
    Object message;
    String error;

    public ErrorDTO(ErrorException e) {
        this.statusCode = e.getStatusCode().value();
        this.message = e.getMessage();
        this.error = e.getError();
    }
}