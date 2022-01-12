package com.demo1.commonbean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @Builder
    public ErrorResponse(String error, String errorCode, HttpStatus httpStatus, List<FieldError> fieldErrors, boolean silentErrorLog) {
        if(error != null) {
            this.errors = Collections.singletonList(error);
        }
        if(errorCode != null) {
            this.type = errorCode;
        }
        if(httpStatus != null){
            this.status = httpStatus.value();
        }
        if(fieldErrors != null && !fieldErrors.isEmpty()) {
            this.errorFormFields = fieldErrors.stream()
                    .map(fieldError -> new ErrorFormField(fieldError.getField(), fieldError.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
        this.silentErrorLog = silentErrorLog;
    }
    @JsonIgnore
    @Builder.Default
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    @JsonIgnore
    @Builder.Default
    private Integer status = HttpStatus.BAD_REQUEST.value();

    @JsonIgnore
    @Builder.Default
    private boolean silentErrorLog = false;

    private String type;
    private List<String> errors ;
    private List<ErrorFormField> errorFormFields;
}
