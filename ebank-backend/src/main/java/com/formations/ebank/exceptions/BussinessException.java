package com.formations.ebank.exceptions;

public class BussinessException extends RuntimeException  {

    public BussinessException(String stringMessageException){
        super( stringMessageException);
    }
}
