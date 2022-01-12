package com.demo1.exception;

import com.demo1.commonbean.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {

        if (ex.getError().isSilentErrorLog()) {

        } else if (ex.getError() != null) {
            log.error("{}", ex.getError().toString());
        } else {
            log.error("Unable to get error object from AppException. Showing generic error.");
        }

        ErrorResponse errorResponse = ex.getError() == null ? getGenericErrorCode() : ex.getError();
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);

    }

    private ErrorResponse getGenericErrorCode(){
        return ErrorResponse.builder().errorCode("500")
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .error("Unable to process with null error response.").build();
    }
}