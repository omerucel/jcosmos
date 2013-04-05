package com.github.omerucel.jcosmos.error;

public class UnauthorizedError extends ErrorAbstract{
    public final static int ERROR_CODE = 401;

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
    
}
