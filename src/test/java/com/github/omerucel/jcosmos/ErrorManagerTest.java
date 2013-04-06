package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.BadRequestError;
import com.github.omerucel.jcosmos.error.ErrorAbstract;
import com.github.omerucel.jcosmos.error.InternalServerError;
import com.github.omerucel.jcosmos.error.ValidationError;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    @Test
    public void toJsonString() throws ParseException
    {
        ErrorManager errorManager = new ErrorManager();

        JSONParser jsonParser = new JSONParser();
        JSONArray validationErrors = (JSONArray) jsonParser.parse(
                errorManager.toJsonString());

        assertEquals(0, validationErrors.size());

        errorManager.addError(new ValidationError("field1", "required", "field1-message"));
        validationErrors = (JSONArray) jsonParser.parse(
                errorManager.toJsonString(ValidationError.class));

        assertEquals(1, validationErrors.size());

        JSONObject error1 = (JSONObject) validationErrors.get(0);
        assertTrue(error1.containsKey("field"));
        assertTrue(error1.containsKey("validation_type"));
        assertTrue(error1.containsKey("message"));
        assertTrue(error1.containsKey("error_code"));
        assertEquals("field1", error1.get("field").toString());
        assertEquals("required", error1.get("validation_type").toString());
        assertEquals("field1-message", error1.get("message").toString());
        assertEquals("400", error1.get("error_code").toString());

        errorManager.addError(new BadRequestError());
        validationErrors = (JSONArray) jsonParser.parse(
                errorManager.toJsonString(ValidationError.class));

        assertEquals(1, validationErrors.size());
        assertEquals(2, errorManager.getErrors().size());

        JSONArray allErrors = (JSONArray) jsonParser.parse(errorManager.toJsonString());
        assertEquals(2, allErrors.size());
    }
}
