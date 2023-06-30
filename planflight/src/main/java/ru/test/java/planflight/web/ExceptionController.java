package ru.test.java.planflight.web;

import org.modelmapper.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.test.java.planflight.exception.PlanFlightException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = MappingException.class)
    protected void handleConflictConstraint(HttpServletResponse response, MappingException ex) throws IOException {
        ex.printStackTrace();
        if(ex.getCause() instanceof PlanFlightException) {
            var message = ex.getCause().getMessage();
            response.sendError(readStatus((PlanFlightException)ex.getCause()), message);
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }

    }

    private int readStatus(PlanFlightException ex) {
        return ex.getClass().getDeclaredAnnotation(ResponseStatus.class)
                .value()
                .value();
    }

}
