package com.cgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.service.JogoDoBichoService;
import com.cgi.utils.Enum.Animais;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "jogo-do-bicho")
@RequiredArgsConstructor
public class JogoDoBichoController {

    @Autowired
    JogoDoBichoService jogoDoBichoService;

    @PostMapping("aposta")
    public ResponseEntity apostar(
            @RequestParam(required = true) int valor,
            @RequestParam Animais animais,
            HttpServletRequest request) {

        return jogoDoBichoService.fazerAposta(animais, valor, request);

    }

    @PostMapping("sortear")
    public ResponseEntity sortearApostador(
            HttpServletRequest request) {

        return jogoDoBichoService.sortearAposta(request);

    }

}