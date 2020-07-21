package com.cel.hexarchsample.infrastructure.adapter.rest.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum Error {

    CUSTOMER_NOT_FOUND("Customer {} could not be found on the system", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);

    public final String errorMessage;
    public final HttpStatus errorStatus;
}
