package com.demo1.exception;

import com.demo1.commonbean.ErrorResponse;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class AppException extends RuntimeException{
private ErrorResponse error;
}