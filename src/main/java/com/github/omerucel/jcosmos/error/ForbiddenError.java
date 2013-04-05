package com.github.omerucel.jcosmos.error;

public class ForbiddenError extends ErrorAbstract{
    public static final int ERROR_CODE = 403;

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }

}
