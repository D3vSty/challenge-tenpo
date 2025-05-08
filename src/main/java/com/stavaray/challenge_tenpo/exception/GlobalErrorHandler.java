package com.stavaray.challenge_tenpo.exception;

import com.stavaray.challenge_tenpo.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> body = Map.of(
                Constants.KEY_ERROR, "ValidationFailed",
                Constants.KEY_DETAILS, ex.getBindingResult().getFieldErrors()
                        .stream()
                        .map(f -> f.getField() + " " + f.getDefaultMessage())
                        .toList(),
                Constants.KEY_STATUS, HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<Map<String, Object>> handleExternal(ExternalServiceException ex) {
        Map<String, Object> body = Map.of(
                Constants.KEY_ERROR, "ExternalServiceError",
                Constants.KEY_MESSAGE, ex.getMessage(),
                Constants.KEY_STATUS, HttpStatus.BAD_GATEWAY.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAll(Exception ex) {
        Map<String, Object> body = Map.of(
                Constants.KEY_ERROR, "InternalError",
                Constants.KEY_MESSAGE, ex.getMessage(),
                Constants.KEY_STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
