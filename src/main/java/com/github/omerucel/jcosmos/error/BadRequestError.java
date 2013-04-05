package com.github.omerucel.jcosmos.error;

public class BadRequestError extends ErrorAbstract{
    public static final int ERROR_CODE = 400;

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
    
}
