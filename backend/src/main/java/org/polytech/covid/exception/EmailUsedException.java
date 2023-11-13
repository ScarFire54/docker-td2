package org.polytech.covid.exception;



public class EmailUsedException extends CovidApiException{

    public EmailUsedException() {
        super("Email is already used",400);
    }


}
