package br.ufg.petsadoption.exceptions;

import br.ufg.petsadoption.models.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> internalServerErrorHandler(Exception ex, WebRequest request) {
        return ResponseEntity
                .internalServerError()
                .body(
                        new ErrorMessage(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                ex.getMessage(),
                                request.getDescription(false),
                                LocalDateTime.now()
                        )
                );
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ErrorMessage> notFoundHandler(NotFoundException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorMessage(
                                HttpStatus.NOT_FOUND.value(),
                                ex.getMessage(),
                                request.getDescription(false),
                                LocalDateTime.now()
                        )
                );
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<ErrorMessage> unauthorizedHandler(AuthenticationException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(
                        new ErrorMessage(
                                HttpStatus.UNAUTHORIZED.value(),
                                ex.getMessage(),
                                request.getDescription(false),
                                LocalDateTime.now()
                        )
                );
    }
}
