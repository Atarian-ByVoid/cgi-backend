package com.cgi.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.cgi.service.CartaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.Data;

@Data
@Component
public class PagamentoRequestConsumidor {

    private final CartaoService cartaoService;

    @KafkaListener(topics = "${topicos.pagamento.request.topic}", groupId = "pagamento-request-consumer-1")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {

        cartaoService.requisitarTransacao(message);
        System.out.println("===== MENSAGEM RECEBIDA === " + message);
    }
}
