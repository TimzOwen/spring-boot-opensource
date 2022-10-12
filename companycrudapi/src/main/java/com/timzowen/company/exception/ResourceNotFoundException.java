package com.timzowen.company.exception;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID=1L;
    private final String companyName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(String companyName, String fieldName, Object fieldValue) {
        super(String.format("%s Not Found for %s : %s ",companyName,fieldName,fieldValue));
        this.companyName = companyName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
