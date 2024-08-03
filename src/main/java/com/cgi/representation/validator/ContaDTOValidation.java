package com.cgi.representation.validator;

import com.cgi.utils.Enum.TipoConta;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContaDTOValidation {

    @NotBlank(message = "tipo conta é obrigatório", groups = ContaValidation.Create.class)
    private TipoConta tipoConta;

    public class ContaValidation {

        public interface Create {

        }
    }

}
