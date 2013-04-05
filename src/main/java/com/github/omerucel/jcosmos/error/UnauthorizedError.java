package com.github.omerucel.jcosmos.error;

public class UnauthorizedError extends ErrorAbstract{
    public final static int ERROR_CODE = 401;

    public UnauthorizedError()
    {
        super("Unauthorized");
    }

    public UnauthorizedError(String message)
    {
        super(message);
    }

    @Override
    public int getErrorCode() {
        return ERROR_CODE;
    }
    
}
