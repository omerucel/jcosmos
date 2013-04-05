package com.github.omerucel.jcosmos.error;

public class NotFoundError extends ErrorAbstract{
    public static final int ERROR_CODE = 404;

    public NotFoundError()
    {
        super("Not Found");
    }

    public NotFoundError(String message)
    {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
}
