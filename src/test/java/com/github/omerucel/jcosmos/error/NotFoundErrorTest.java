package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.*;
import org.junit.Test;

public class NotFoundErrorTest {
    @Test
    public void instance()
    {
        NotFoundError error = new NotFoundError();
        assertTrue(error instanceof Error);
        assertEquals("Not Found", error.getMessage());
        assertEquals(404, error.getErrorCode());
    }
}
