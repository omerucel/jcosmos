package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.BadRequestError;
import com.github.omerucel.jcosmos.error.ErrorAbstract;
import com.github.omerucel.jcosmos.error.InternalServerError;
import com.github.omerucel.jcosmos.error.ValidationError;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ErrorManagerTest {
    @Test
    public void addAndGetError()
    {
        ErrorManager errorManager = new ErrorManager();
        errorManager.addError(new BadRequestError());
        assertEquals(1, errorManager.getErrors().size());

        ArrayList<ErrorAbstract> errors = new ArrayList<ErrorAbstract>();
        errors.add(new BadRequestError());
        errors.add(new InternalServerError());

        errorManager.addErrors(errors);
        assertEquals(3, errorManager.getErrors().size());
    }

    @Test
    public void hasError()
    {
        ErrorManager errorManager = new ErrorManager();
        assertFalse(errorManager.hasError());

        errorManager.addError(new BadRequestError());
        assertTrue(errorManager.hasError());

        assertTrue(errorManager.hasError(BadRequestError.class));
        assertFalse(errorManager.hasError(ValidationError.class));
    }
}
