package ru.test.java.planflight.exception;

public class PlanFlightException extends RuntimeException {


    public PlanFlightException(String message) {
        super(message);
    }

    public PlanFlightException(String message, Object ... args) {
        super(String.format(message, args));
    }

    public PlanFlightException(String message, Throwable cause) {
        super(message, cause);
    }
}
