package org.polytech.covid.exception;

public class UserNotFoundException extends CovidApiException{

    public UserNotFoundException(){
        super("User does not exist",404);
    }
}
