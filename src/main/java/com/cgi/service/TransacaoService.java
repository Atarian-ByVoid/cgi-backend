package com.cgi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.auth.JwtService;
import com.cgi.errors.ErrorException;
import com.cgi.mapper.TransacaoMapper;
import com.cgi.model.Conta;
import com.cgi.model.Transacao;
import com.cgi.repository.ContaRepository;
import com.cgi.repository.TransacaoRepository;
import com.cgi.representation.TransacaoDTO;
import com.cgi.utils.Enum.TipoTransacao;

import jakarta.servlet.http.HttpServletRequest;

@Service
@SuppressWarnings("null")
public class TransacaoService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    TransacaoMapper transacaoMapper;

    @Autowired
    private JwtService jwtService;

    @Transactional
    public ResponseEntity realizarTransacao(
            TransacaoDTO transacaoDTO,
            double valor,
            HttpServletRequest request) {

        String token = jwtService.extractToken(request);
        String userId = jwtService.getUserIdFromToken(token);
        UUID accountId = UUID.fromString(userId);

        Conta contaOrigem = contaRepository.findById(
                accountId)
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Conta de origem não encontrada", "NOT_FOUND"));

        Conta contaDestino = contaRepository.findById(transacaoDTO.getContaDestino().getId())
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Conta de destino não encontrada", "NOT_FOUND"));

        if (contaOrigem.getSaldo() >= valor) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);

            contaRepository.save(contaOrigem);
            contaRepository.save(contaDestino);

            Transacao transacao = new Transacao();
            transacao.setTipoTransacao(TipoTransacao.TRANSFERENCIA);
            transacao.setValorTransacao(valor);
            transacao.setConta(contaOrigem);
            transacaoRepository.save(transacao);

        } else {
            throw new ErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível realizar a transação no momento, tente mais tarde", "Internal Server Error");
        }
        return null;
    }
}
