package ru.test.java.planflight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends PlanFlightException {

    public NotFoundException(String message, Object ... args) {
        super(String.format(message, args));
    }
}
