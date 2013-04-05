package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InternalServerErrorTest {
    @Test
    public void instance()
    {
        InternalServerError error = new InternalServerError();
        assertTrue(error instanceof Error);
        assertEquals(500, error.getErrorCode());
    }
}
