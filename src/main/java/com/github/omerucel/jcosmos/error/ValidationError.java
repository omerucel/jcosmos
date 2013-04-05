package com.github.omerucel.jcosmos.error;

public class ValidationError extends Error{
    private final static int errorCode = 400;

    String fieldName;
    String errorType;

    ValidationError(String fieldName, String errortype, String message) {
        super(message);

        this.fieldName = fieldName;
        this.errorType = errortype;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorType() {
        return errorType;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
