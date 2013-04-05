package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.*;
import org.junit.Test;

public class BadRequestErrorTest {
    @Test
    public void instance()
    {
        BadRequestError error = new BadRequestError();
        assertTrue(error instanceof ErrorAbstract);
        assertEquals(400, error.getErrorCode());
    }
}
