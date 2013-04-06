package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.ErrorAbstract;
import com.github.omerucel.jcosmos.error.ValidationError;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ErrorManager {
    private ArrayList<ErrorAbstract> errors;

    public Boolean hasError() {
        return !(errors == null || getErrors().isEmpty());
    }

    public Boolean hasError(Class err) {
        if (errors == null || getErrors().isEmpty()) return false;

        for(ErrorAbstract error : getErrors())
            if (err.isInstance(error))
                return true;

        return false;
    }

    public void addError(ErrorAbstract error) {
        getErrors().add(error);
    }

    public void addErrors(ArrayList<ErrorAbstract> errors) {
        getErrors().addAll(errors);
    }

    public ArrayList<ErrorAbstract> getErrors()
    {
        if (errors == null)
             errors = new ArrayList<ErrorAbstract>();

        return errors;
    }

    public String toJsonString(Class aClass)
    {
        JSONArray list = new JSONArray();

        for(ErrorAbstract error : getErrors())
        {
            if (!aClass.isInstance(error)) continue;

            JSONObject temp = new JSONObject();
            temp.put("message", error.getMessage());
            temp.put("error_code", error.getErrorCode());

            if (error instanceof ValidationError)
            {
                temp.put("field", ((ValidationError)error).getFieldName());
                temp.put("validation_type", ((ValidationError)error).getErrorType());
            }

            list.add(temp);
        }

        return list.toJSONString();
    }

    public String toJsonString()
    {
        return toJsonString(ErrorAbstract.class);
    }
}
