package com.github.omerucel.jcosmos;

import java.util.HashMap;
import javax.validation.constraints.NotNull;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidatorTest {
    public static class Dummy extends Validator.Form{
        @NotNull
        public String email;

        @NotNull
        public String firstName;

        public void setEmail(String email)
        {
            this.email = email;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }
    }

    @Test
    public void bind()
    {
        HashMap<Object, Object> data = new HashMap<Object, Object>();
        data.put("email", "test");
        data.put("first_name", "test");

        Dummy dummy = new Dummy();
        dummy.bind(data);

        assertEquals("test", dummy.email);
        assertEquals("test", dummy.firstName);
    }

    @Test
    public void isValid()
    {
        HashMap<Object, Object> data = new HashMap<Object, Object>();
        data.put("email", "test");

        Dummy dummy = new Dummy();
        dummy.bind(data);

        Validator<Dummy> validator = new Validator<Dummy>();
        assertFalse(validator.isValid(dummy));
    }
}
