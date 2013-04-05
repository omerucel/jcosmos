package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.*;
import org.junit.Test;

public class BadRequestErrorTest {
    @Test
    public void instance()
    {
        BadRequestError error = new BadRequestError();
        assertTrue(error instanceof ErrorAbstract);
        assertEquals("Bad Request", error.getMessage());
        assertEquals(400, error.getErrorCode());
    }
}
