package com.cgi.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cgi.auth.JwtService;
import com.cgi.errors.ErrorException;
import com.cgi.mail.MailService;
import com.cgi.model.Aposta;
import com.cgi.model.Usuario;
import com.cgi.repository.ApostaRepository;
import com.cgi.repository.UsuarioRepository;
import com.cgi.utils.Enum.Animais;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class JogoDoBichoService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MailService mailService;

    @Transactional
    public ResponseEntity fazerAposta(Animais animalEscolhido, int numeroEscolhido,
            HttpServletRequest request) {

        String token = jwtService.extractToken(request);
        String userId = jwtService.getUserIdFromToken(token);
        UUID accountId = UUID.fromString(userId);

        Usuario usuario = usuarioRepository.findByIdJoinConta(accountId)
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Usuario não encontrado", "Not Found"));

        double valorAposta = 10.00;

        if (usuario.getConta().getSaldo() < valorAposta) {
            throw new ErrorException(HttpStatus.BAD_REQUEST,
                    "Saldo insuficiente para fazer a aposta", "Bad Request");
        }

        usuario.getConta().setSaldo(usuario.getConta().getSaldo() - valorAposta);

        Aposta aposta = new Aposta();
        aposta.setAnimais(animalEscolhido);
        aposta.setNumero(numeroEscolhido);
        aposta.setUsuario(usuario);

        this.apostaRepository.save(aposta);

        return ResponseEntity.ok("Aposta feita.");
    }

    @Transactional
    public ResponseEntity<?> sortearAposta(HttpServletRequest request) {
        List<Aposta> todasAsApostas = apostaRepository.findAll();
        if (todasAsApostas.isEmpty()) {
            throw new ErrorException(HttpStatus.NOT_FOUND, "Não há apostas cadastradas.", "Not Found");
        }

        Random random = new Random();
        Aposta apostaSorteada = todasAsApostas.get(random.nextInt(todasAsApostas.size()));

        Usuario usuarioDaAposta = apostaSorteada.getUsuario();

        // this.mailService.sendSorteioAposta(usuarioDaAposta, apostaSorteada);

        return ResponseEntity.ok("Sorteio feito com sucesso.");
    }

}
