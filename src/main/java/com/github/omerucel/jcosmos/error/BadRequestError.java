package com.github.omerucel.jcosmos.error;

public class BadRequestError extends ErrorAbstract{
    public static final int ERROR_CODE = 400;

    public BadRequestError()
    {
        super("Bad Request");
    }

    public BadRequestError(String message)
    {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
    
}
