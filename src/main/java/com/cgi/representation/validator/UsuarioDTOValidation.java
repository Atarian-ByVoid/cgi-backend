package com.cgi.representation.validator;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTOValidation {

    @NotBlank(message = "O primeiro nome é obrigatório", groups = UsuarioValidation.Create.class)
    private String nome;

    @NotBlank(message = "O email é obrigatório", groups = UsuarioValidation.Create.class)
    @Email(message = "O e-mail está no fomrato inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória", groups = UsuarioValidation.Create.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @NotBlank(message = "Documento é obrigatório", groups = UsuarioValidation.Create.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String documento;

    private EnderecoDTOValidation endereco = new EnderecoDTOValidation();;

    private TelefoneDTOValidation telefone = new TelefoneDTOValidation();;

    private ContaDTOValidation conta = new ContaDTOValidation();

    public class UsuarioValidation {

        public interface Create {

        }

    }

}
