package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.ErrorAbstract;
import java.util.ArrayList;

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
}
