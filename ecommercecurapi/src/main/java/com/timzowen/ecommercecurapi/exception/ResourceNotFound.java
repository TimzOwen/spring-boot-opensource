package com.timzowen.ecommercecurapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFound(String firstName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s ", firstName,fieldName,fieldValue));
        this.firstName = firstName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
