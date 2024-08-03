package com.cgi.representation;

import java.time.LocalDate;

import com.cgi.representation.others.AbstractDTO;
import com.cgi.representation.others.AbstractDTO.AbstractDTOViews.TodasInformacoes;
import com.cgi.representation.others.AbstractViews;
import com.cgi.utils.Enum.TipoCartao;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CartaoDTO extends AbstractDTO {

    @JsonView({ CartaoViews.Send.class })
    private String numero;

    @JsonView({ CartaoViews.Send.class })
    private String titular;

    @JsonView({ CartaoViews.Send.class })
    private LocalDate dataValidade;

    @JsonView({ CartaoViews.Send.class })
    private String cvv;

    @JsonView({ CartaoViews.Send.class })
    private TipoCartao tipoCartao;

    @JsonView({ CartaoViews.Send.class })
    private String bandeira;

    @JsonView({ CartaoViews.ValidarPorAPI.class })
    private String documento;

    public class CartaoViews extends AbstractViews {
        public interface Send {

        }

        public interface Get extends Send, TodasInformacoes {

        }

        public interface ValidarPorAPI extends Send {

        }

    }

}
