package com.cgi.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cgi.auth.JwtService;
import com.cgi.errors.ErrorException;
import com.cgi.mapper.CartaoMapper;
import com.cgi.model.Cartao;
import com.cgi.model.Usuario;
import com.cgi.repository.CartaoRepository;
import com.cgi.repository.UsuarioRepository;
import com.cgi.representation.CartaoDTO;
import com.cgi.representation.TransacaoDTO;
import com.cgi.representation.validator.CartaoDTOValidation;
import com.cgi.representation.validator.TransacaoDTOValidation;
import com.cgi.utils.CartaoUtil;
import com.cgi.utils.Enum.TipoCartao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartaoService {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final CartaoRepository cartaoRepository;
    private final CartaoMapper cartaoMapper;
    private final ObjectMapper objectMapper;

    public CartaoDTO create(HttpServletRequest request, TipoCartao tipoCartao) {
        String token = jwtService.extractToken(request);
        String userId = jwtService.getUserIdFromToken(token);
        UUID accountId = UUID.fromString(userId);

        Usuario usuario = usuarioRepository.findByIdJoinConta(accountId)
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado", "Not Found"));

        if (usuario.getCartao() != null) {
            throw new ErrorException(HttpStatus.BAD_REQUEST,
                    "O usuário já possui um cartão", "Bad Request");
        }

        Cartao cartao = new Cartao();
        cartao.setBandeira("CGI");
        cartao.setCvv(CartaoUtil.gerarCVV());
        cartao.setDataValidade(LocalDate.now().plusYears(3));
        cartao.setNumero(CartaoUtil.gerarNumeroCartao());
        cartao.setTitular(usuario.getNome().toUpperCase());
        cartao.setTipoCartao(tipoCartao);
        cartao.setUsuario(usuario);

        usuario.setCartao(cartao);

        usuarioRepository.save(usuario);

        return cartaoMapper.convertToCartaoDTO(cartao);
    }

    public CartaoDTO findById(HttpServletRequest token) {

        String authToken = jwtService.extractToken(token);

        String userId = jwtService.getUserIdFromToken(authToken);
        UUID accountId = UUID.fromString(userId);

        Usuario usuario = usuarioRepository.findById(accountId)
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Usuario não encontrado", "Not Found"));

        return cartaoMapper.convertToCartaoDTO(usuario.getCartao());

    }

    public Boolean validarCartao(CartaoDTOValidation request) {
        if (request.getCvv() == null || request.getNumero() == null ||
                request.getDataValidade() == null || request.getTitular() == null) {
            throw new ErrorException(HttpStatus.BAD_REQUEST, "Todos os campos do cartão devem ser preenchidos",
                    "Bad Request");
        }

        cartaoRepository.validarCartao(
                request.getCvv(), request.getNumero(), request.getDataValidade(), request.getTitular(),
                request.getDocumento())
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Cartão solicitado para validação não encontrado", "Not Found"));

        return true;
    }

    public Boolean requisitarTransacao(TransacaoDTOValidation request) {

        return true;

    }

    public Boolean requisitarTransacao(String message) throws JsonMappingException, JsonProcessingException {

        TransacaoDTO transacao = objectMapper.readValue(message, TransacaoDTO.class);

        CartaoDTO cartaoDTO = transacao.getCartaoDTO();

        Cartao cartao = cartaoRepository
                .validarCartao(cartaoDTO.getCvv(), cartaoDTO.getNumero(), cartaoDTO.getDataValidade(),
                        cartaoDTO.getTitular(), cartaoDTO.getDocumento())
                .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND,
                        "Cartão solicitado para validação não encontrado", "Not Found"));

        usuarioRepository.findByCpf(cartaoDTO.getDocumento());

        return true;

    }

}
