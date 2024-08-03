package com.cgi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.representation.CartaoDTO;
import com.cgi.representation.CartaoDTO.CartaoViews;
import com.cgi.service.CartaoService;
import com.cgi.utils.Enum.TipoCartao;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "cartao")
@AllArgsConstructor
public class CartaoController {

    private final CartaoService cartaoService;

    @PostMapping
    @JsonView(CartaoViews.Get.class)
    public ResponseEntity<CartaoDTO> criarCartao(
            HttpServletRequest request,
            TipoCartao tipoCartao) {

        CartaoDTO cartaoDTO = cartaoService.create(request, tipoCartao);

        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDTO);
    }

    @GetMapping()
    @JsonView(CartaoViews.Get.class)
    public ResponseEntity<CartaoDTO> buscarCartao(
            HttpServletRequest token) {

        CartaoDTO cartaoDTO = cartaoService.findById(token);

        return ResponseEntity.ok(cartaoDTO);
    }
}
