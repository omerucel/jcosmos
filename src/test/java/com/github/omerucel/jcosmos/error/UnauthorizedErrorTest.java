package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnauthorizedErrorTest {
    @Test
    public void instance()
    {
        UnauthorizedError error = new UnauthorizedError();
        assertTrue(error instanceof Error);
        assertEquals(401, error.getErrorCode());
    }
}
