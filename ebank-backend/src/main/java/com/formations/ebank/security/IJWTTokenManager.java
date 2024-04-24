package com.formations.ebank.security;

public interface IJWTTokenManager {
    Boolean verifierValiditerToken(String token);
}
