package com.cgi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.errors.ErrorException;
import com.cgi.representation.ErrorDTO;
import com.cgi.representation.validator.CartaoDTOValidation;
import com.cgi.representation.validator.CartaoDTOValidation.CartaoValidation;
import com.cgi.representation.validator.TransacaoDTOValidation;
import com.cgi.representation.validator.TransacaoDTOValidation.TransacaoValidation;
import com.cgi.service.CartaoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "validacao")
@AllArgsConstructor
public class ValidacaoController {

    private final CartaoService cartaoService;

    @PostMapping("/validar-cartao")
    public ResponseEntity<Object> validarCartao(
            @Validated({ CartaoValidation.Validate.class }) @RequestBody CartaoDTOValidation request) {
        try {
            boolean cartaoValido = cartaoService.validarCartao(request);
            if (cartaoValido) {
                return ResponseEntity.ok("Cartão válido");
            } else {
                return ResponseEntity.badRequest().body("Cartão inválido");
            }
        } catch (ErrorException e) {
            ErrorDTO errorDTO = new ErrorDTO(e);
            return ResponseEntity.status(e.getStatusCode()).body(errorDTO);
        }
    }

    @PostMapping("/requisitar-transacao")
    public ResponseEntity<Object> validarCartao(
            @Validated({ TransacaoValidation.ParaTransacao.class }) @RequestBody TransacaoDTOValidation request) {
        try {
            boolean transacao = cartaoService.requisitarTransacao(request);
            if (transacao) {
                return ResponseEntity.ok("Transação aprovada");
            } else {
                return ResponseEntity.badRequest().body("Transação não aprovada");
            }
        } catch (ErrorException e) {
            ErrorDTO errorDTO = new ErrorDTO(e);
            return ResponseEntity.status(e.getStatusCode()).body(errorDTO);
        }
    }

}
