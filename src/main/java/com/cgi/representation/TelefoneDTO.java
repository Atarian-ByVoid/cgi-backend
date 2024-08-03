package com.cgi.representation;

import java.time.LocalDateTime;

import com.cgi.utils.Enum.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class TelefoneDTO {

    @JsonView({ TelefoneViews.Detalhado.class })
    private LocalDateTime criadoEm;

    @JsonView({ TelefoneViews.Detalhado.class })
    private LocalDateTime alteradoEm;

    @JsonView({ TelefoneViews.Detalhado.class })
    private LocalDateTime deletadoEm;

    @JsonView({ TelefoneViews.Send.class })
    private String numero;

    @JsonView({ TelefoneViews.Send.class })
    private TipoTelefone tipo;

    @JsonView({ TelefoneViews.Send.class })
    private String ramal;

    public class TelefoneViews {
        public interface Send {

        }

        public interface Detalhado extends Send {

        }
    }
}
