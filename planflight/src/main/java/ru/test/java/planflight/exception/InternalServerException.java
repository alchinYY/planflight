package ru.test.java.planflight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends PlanFlightException {
    public InternalServerException(String message) {
        super(message);
    }
}
