package com.github.omerucel.jcosmos.error;

abstract public class ErrorAbstract extends Error{
    abstract public int getErrorCode();

    public ErrorAbstract()
    {
        super("Error");
    }

    public ErrorAbstract(String message)
    {
        super(message);
    }
}
