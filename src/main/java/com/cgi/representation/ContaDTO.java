package com.cgi.representation;

import java.time.LocalDateTime;
import java.util.UUID;

import com.cgi.utils.Enum.TipoConta;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class ContaDTO {
    @JsonView({ ContaViews.Detalhado.class })
    private LocalDateTime criadoEm;

    @JsonView({ ContaViews.Detalhado.class })
    private LocalDateTime alteradoEm;

    @JsonView({ ContaViews.Detalhado.class })
    private LocalDateTime deletadoEm;

    @JsonView({ ContaViews.Send.class })
    private TipoConta tipoConta;

    @JsonView({ ContaViews.Detalhado.class })
    private Double saldo;

    @JsonView({ ContaViews.ParaTransacao.class })
    private UUID id;

    public class ContaViews {
        public interface Send {

        }

        public interface Detalhado extends Send {

        }

        public interface ParaTransacao {

        }
    }

}
