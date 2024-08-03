package com.cgi.representation.validator;

import com.cgi.utils.Enum.TipoTelefone;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TelefoneDTOValidation {

    @NotBlank(message = "numero é obrigatório", groups = TelefoneValidation.Create.class)
    private String numero;

    @NotBlank(message = "tipo telefone é obrigatório", groups = TelefoneValidation.Create.class)
    private TipoTelefone tipo;

    @NotBlank(message = "ramal é obrigatório", groups = TelefoneValidation.Create.class)
    private String ramal;

    public class TelefoneValidation {

        public interface Create {

        }

    }

}
