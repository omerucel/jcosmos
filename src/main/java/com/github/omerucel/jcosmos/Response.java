package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.ErrorAbstract;
import java.util.ArrayList;

public class Response {
    private int httpErrorCode = 0;
    private int applicationErrorCode = 0;
    private ArrayList<ErrorAbstract> errors;

    public int getApplicationErrorCode() {
        return applicationErrorCode;
    }

    public void setApplicationErrorCode(int applicationErrorCode) {
        this.applicationErrorCode = applicationErrorCode;
    }

    public int getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(int httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    public void addError(ErrorAbstract error) {
        getErrors().add(error);
    }

    public ArrayList<ErrorAbstract> getErrors()
    {
        if (errors == null)
             errors = new ArrayList<ErrorAbstract>();

        return errors;
    }
}
