package whatsapp.whatsapp.interfaces.rest.error;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import whatsapp.whatsapp.application.exceptions.UserNotFoundException;
import whatsapp.whatsapp.application.exceptions.UserTagConflictException;

import java.time.Instant;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    // --- USER NOT FOUND EXCEPTION --- //
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ErrorResponse> userNotFoundHandler(
        UserNotFoundException ex,
        HttpServletRequest req
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildError(HttpStatus.NOT_FOUND, ex.getMessage(), req.getRequestURI()));
    }

    // --- USERTAG CONFLICT EXCEPTION --- //
    @ExceptionHandler(UserTagConflictException.class)
    private ResponseEntity<ErrorResponse> userTagConflictHandler(
            UserTagConflictException ex,
            HttpServletRequest req
    ) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(buildError(HttpStatus.CONFLICT, ex.getMessage(), req.getRequestURI()));
    }


    // --- Helper BuildError Function --- //
    private ErrorResponse buildError(
            HttpStatus status,
            String message,
            String path
    ) {
        return new ErrorResponse(
                status.value(),
                message,
                path,
                Instant.now()
        );
    }

}