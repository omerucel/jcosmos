package com.github.omerucel.jcosmos;

public class Response extends ErrorManager{
    private int httpErrorCode = 0;
    private int applicationErrorCode = 0;

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
}
