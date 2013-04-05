package com.github.omerucel.jcosmos.error;

public class InternalServerError extends ErrorAbstract{
    public static final int ERROR_CODE = 500;

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }

}
