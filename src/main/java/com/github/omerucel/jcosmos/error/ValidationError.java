package com.github.omerucel.jcosmos.error;

public class ValidationError extends BadRequestError{
    String fieldName;
    String errorType;

    public ValidationError(String fieldName, String errorType)
    {
        this(fieldName, errorType, "Validation Error");
    }

    public ValidationError(String fieldName, String errorType, String message)
    {
        super(message);
        this.fieldName = fieldName;
        this.errorType = errorType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorType() {
        return errorType;
    }
}
