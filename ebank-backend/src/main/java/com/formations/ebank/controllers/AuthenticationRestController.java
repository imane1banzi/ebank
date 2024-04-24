package com.formations.ebank.controllers;


import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/") // sur mesure
@RestController
@RequestMapping("ebank/")
 @Slf4j
public class AuthenticationRestController {



    @GetMapping("login")
    public void login() {

      /*
        log.info("Login page"); */
    }
}
