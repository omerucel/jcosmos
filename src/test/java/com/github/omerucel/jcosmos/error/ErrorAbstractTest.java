package com.github.omerucel.jcosmos.error;


import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class ErrorAbstractTest {
    @Test
    public void instance()
    {
        ErrorAbstract error = Mockito.spy(new ErrorAbstract() {

            @Override
            public int getErrorCode() {
                return 0;
            }
        });
        assertTrue(error instanceof Error);
    }
}
