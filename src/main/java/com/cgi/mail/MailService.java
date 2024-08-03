package com.cgi.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.model.Aposta;
import com.cgi.model.Usuario;

@Service
public class MailService {

    private final static String URL = "http://localhost:4200/";

    @Autowired
    private final MailBuilder mailBuilder;

    @Autowired
    public MailService(MailBuilder mailBuilder) {
        this.mailBuilder = mailBuilder;
    }

    public void sendEmailCadastro(Usuario usuario) {
        Map<String, Object> params = new HashMap<>();

        params.put("nome", usuario.getNome());
        params.put("loginLink", URL);

        mailBuilder.to(usuario.getEmail())
                .subject("Welcome to CGIBank").fire("welcome/body.html", params);
    }

    public void sendJogoDoBicho(Usuario usuario) {
        Map<String, Object> params = new HashMap<>();

        params.put("nome", usuario.getNome());
        params.put("loginLink", URL);

        mailBuilder.to(usuario.getEmail())
                .subject("Try a bet").fire("jogo-do-bicho/body.html", params);
    }

    public void sendSorteioAposta(Usuario usuario, Aposta aposta) {
        Map<String, Object> params = new HashMap<>();

        params.put("nome", usuario.getNome());
        params.put("animal", aposta.getAnimais().getImagem());
        params.put("loginLink", URL);

        mailBuilder.to(usuario.getEmail())
                .subject("Congratulations on Winning the Animal Lottery Draw!").fire("aposta/body.html", params);
    }

}
