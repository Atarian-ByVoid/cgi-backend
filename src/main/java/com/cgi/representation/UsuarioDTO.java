package com.cgi.representation;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UsuarioDTO {

    @JsonView({ UsuarioViews.Detalhado.class })
    private LocalDateTime criadoEm;

    @JsonView({ UsuarioViews.Detalhado.class })
    private LocalDateTime alteradoEm;

    @JsonView({ UsuarioViews.Detalhado.class })
    private LocalDateTime deletadoEm;

    @JsonView({ UsuarioViews.Send.class })
    private String nome;

    @JsonView({ UsuarioViews.Send.class })
    private String email;

    @JsonView({ UsuarioViews.Send.class })
    private String senha;

    @JsonView({ UsuarioViews.Send.class })
    private String documento;

    @JsonView({ UsuarioViews.Send.class })
    private EnderecoDTO enderecoDTO;

    @JsonView({ UsuarioViews.Send.class })
    private TelefoneDTO telefoneDTO;

    @JsonView({ UsuarioViews.Send.class })
    private ContaDTO contaDTO;

    public class UsuarioViews {
        public interface Send {

        }

        public interface Detalhado extends Send {

        }
    }
}
