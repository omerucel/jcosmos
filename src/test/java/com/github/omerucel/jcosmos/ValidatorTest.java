package com.github.omerucel.jcosmos;

import static org.junit.Assert.*;
import org.junit.Test;

public class ValidatorTest {
    @Test
    public void instance()
    {
        Validator validator = new Validator();
        assertTrue(validator instanceof ErrorManager);
    }
}
