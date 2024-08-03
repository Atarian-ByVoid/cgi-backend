package com.cgi.representation;

import java.math.BigDecimal;

import com.cgi.representation.ContaDTO.ContaViews;
import com.cgi.representation.ContaDTO.ContaViews.ParaTransacao;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class TransacaoDTO {

    @JsonView({ ContaViews.Send.class })
    private ContaDTO contaOrigem;

    @JsonView({ ContaViews.Send.class })
    private ContaDTO contaDestino;

    @JsonView({ TransacaoViews.ParaPagamento.class })
    private BigDecimal valorTransacao;

    @JsonView({ TransacaoViews.ParaPagamento.class })
    private CartaoDTO cartaoDTO;

    public class TransacaoViews {
        public interface Send extends ParaTransacao {

        }

        public interface Detalhado extends Send {

        }

        public interface ParaPagamento {

        }
    }

}
