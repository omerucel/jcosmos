package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.*;
import org.junit.Test;

public class ValidationErrorTest {
    @Test
    public void instance()
    {
        ValidationError error = new ValidationError("field", "error-type", "message");
        assertTrue(error instanceof Error);
    }

    @Test
    public void getters()
    {
        ValidationError error = new ValidationError("field", "error-type", "message");
        assertEquals(400, error.getErrorCode());
        assertEquals("field", error.getFieldName());
        assertEquals("error-type", error.getErrorType());
        assertEquals("message", error.getMessage());
    }
}
