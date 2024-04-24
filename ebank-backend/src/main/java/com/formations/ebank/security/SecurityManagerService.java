package com.formations.ebank.security;

public interface SecurityManagerService {
    String crypterMotDePasse(String motDePasse,String secretKey);
    String decrypterMotDePasse(String motDePasse,String secretKey);
    String generateAutoPassword();
    String generateAutoLogin(String nom, String prenom);
}
