package com.github.omerucel.jcosmos.error;

public class ValidationError extends BadRequestError{
    String fieldName;
    String errorType;
    String message;

    public ValidationError(String fieldName, String errorType, String message)
    {
        this.fieldName = fieldName;
        this.errorType = errorType;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
