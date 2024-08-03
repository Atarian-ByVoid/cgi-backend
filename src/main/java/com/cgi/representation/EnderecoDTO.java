package com.cgi.representation;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class EnderecoDTO {

    @JsonView({ EnderecoViews.Detalhado.class })
    private LocalDateTime criadoEm;

    @JsonView({ EnderecoViews.Detalhado.class })
    private LocalDateTime alteradoEm;

    @JsonView({ EnderecoViews.Detalhado.class })
    private LocalDateTime deletadoEm;

    @JsonView({ EnderecoViews.Send.class })
    private String logradouro;

    @JsonView({ EnderecoViews.Send.class })
    private String bairro;

    @JsonView({ EnderecoViews.Send.class })
    private String cidade;

    @JsonView({ EnderecoViews.Send.class })
    private String uf;

    @JsonView({ EnderecoViews.Send.class })
    private String pais;

    @JsonView({ EnderecoViews.Send.class })
    private String cep;

    @JsonView({ EnderecoViews.Send.class })
    private String complemento;

    public class EnderecoViews {
        public interface Send {

        }

        public interface Detalhado extends Send {

        }
    }

}
