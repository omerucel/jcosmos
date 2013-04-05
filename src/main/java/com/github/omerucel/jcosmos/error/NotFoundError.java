package com.github.omerucel.jcosmos.error;

public class NotFoundError extends ErrorAbstract{
    public static final int ERROR_CODE = 404;

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
}
