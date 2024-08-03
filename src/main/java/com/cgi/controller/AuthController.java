package com.cgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.representation.records.AccessToken;
import com.cgi.service.AuthService;

@RestController
@RequestMapping(path = "auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AccessToken> login() {
        AccessToken response = authService.login();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
