package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.BadRequestError;
import static org.junit.Assert.*;
import org.junit.Test;

public class ResponseTest {
    @Test
    public void httpErrorCode()
    {
        Response response = new Response();
        assertEquals(0, response.getHttpErrorCode());

        response.setHttpErrorCode(404);
        assertEquals(404, response.getHttpErrorCode());
    }

    @Test
    public void applicationErrorCode()
    {
        Response response = new Response();
        assertEquals(0, response.getApplicationErrorCode());

        response.setApplicationErrorCode(1001);
        assertEquals(1001, response.getApplicationErrorCode());
    }

    @Test
    public void addAndGetError()
    {
        Response response = new Response();
        response.addError(new BadRequestError());
        assertEquals(1, response.getErrors().size());
    }
}
