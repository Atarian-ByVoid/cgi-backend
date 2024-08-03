package com.cgi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.representation.TransacaoDTO;
import com.cgi.service.TransacaoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "transacao")
@RequiredArgsConstructor
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("realizar-transacao")
    public ResponseEntity cadastrar(
            @RequestParam(required = true) Double valor,
            @RequestBody TransacaoDTO conta,
            HttpServletRequest request) {

        transacaoService.realizarTransacao(conta, valor, request);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Transação feita com sucesso.");

        return ResponseEntity.ok(response);

    }

}
