package org.polytech.covid.exception;

public class CovidApiException extends Exception {

    int statusCode;

    public CovidApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
