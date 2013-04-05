package com.github.omerucel.jcosmos.error;

public class ForbiddenError extends ErrorAbstract{
    public static final int ERROR_CODE = 403;

    public ForbiddenError()
    {
        super("Forbidden");
    }

    public ForbiddenError(String message)
    {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }

}
