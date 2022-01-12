package com.demo1.commonbean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorFormField {

private String field;
private String error;

public ErrorFormField(String field, String error) {
this.field = field;
this.error = error;
}
}