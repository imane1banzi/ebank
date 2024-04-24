package com.formations.ebank.utils.exceptions;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class UtilisateurNotFoundException  extends Exception{
    public UtilisateurNotFoundException(String login) {
    }
}
