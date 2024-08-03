package com.cgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.representation.UsuarioDTO;
import com.cgi.representation.validator.UsuarioDTOValidation;
import com.cgi.representation.validator.UsuarioDTOValidation.UsuarioValidation;
import com.cgi.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "usuario")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(
            @Validated({ UsuarioValidation.Create.class }) @RequestBody UsuarioDTOValidation request) {

        UsuarioDTO usuarioDTO = usuarioService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

}
