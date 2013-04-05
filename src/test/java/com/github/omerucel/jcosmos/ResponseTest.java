package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.BadRequestError;
import com.github.omerucel.jcosmos.error.ErrorAbstract;
import com.github.omerucel.jcosmos.error.InternalServerError;
import com.github.omerucel.jcosmos.error.ValidationError;
import java.util.ArrayList;
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

        ArrayList<ErrorAbstract> errors = new ArrayList<ErrorAbstract>();
        errors.add(new BadRequestError());
        errors.add(new InternalServerError());

        response.addErrors(errors);
        assertEquals(3, response.getErrors().size());
    }

    @Test
    public void hasError()
    {
        Response response = new Response();
        assertFalse(response.hasError());

        response.addError(new BadRequestError());
        assertTrue(response.hasError());

        assertTrue(response.hasError(BadRequestError.class));
        assertFalse(response.hasError(ValidationError.class));
    }
}
