package com.cel.hexarchsample.infrastructure.adapter.rest.error;

import com.cel.hexarchsample.infrastructure.exception.BaseInfrastructureException;
import com.cel.hexarchsample.infrastructure.exception.CustomerNotFoundException;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private static final Map<Class<? extends Throwable>, Error> ERROR_MAP = ImmutableMap.<Class<? extends Throwable>, Error>builder()
        .put(CustomerNotFoundException.class, Error.CUSTOMER_NOT_FOUND)
        .build();

    @ExceptionHandler(BaseInfrastructureException.class)
    public ResponseEntity<?> handleBaseInfrastructureException( BaseInfrastructureException exception) {

        Error error = ERROR_MAP.getOrDefault(exception, Error.INTERNAL_SERVER_ERROR);

        HttpStatus httpStatus = error.errorStatus;
        String message = StringSubstitutor.replace(error.errorMessage, exception.metadata());

        return ResponseEntity
            .status(httpStatus)
            .body(message);
    }
}
