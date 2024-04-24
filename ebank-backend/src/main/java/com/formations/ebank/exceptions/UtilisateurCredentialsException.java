package com.formations.ebank.exceptions;

public class UtilisateurCredentialsException extends RuntimeException {

    public UtilisateurCredentialsException(String messageError){
        super(messageError);
    }
}
