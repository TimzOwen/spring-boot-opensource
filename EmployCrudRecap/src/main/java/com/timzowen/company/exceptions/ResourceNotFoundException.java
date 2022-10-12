package com.timzowen.company.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String firstName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String firstName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %sId : %sid ",firstName,fieldName,fieldValue));
        this.firstName = firstName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }
}
