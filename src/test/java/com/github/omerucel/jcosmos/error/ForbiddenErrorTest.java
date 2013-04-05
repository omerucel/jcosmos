package com.github.omerucel.jcosmos.error;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ForbiddenErrorTest {
    @Test
    public void instance()
    {
        ForbiddenError error = new ForbiddenError();
        assertTrue(error instanceof Error);
        assertEquals(403, error.getErrorCode());
    }
}
