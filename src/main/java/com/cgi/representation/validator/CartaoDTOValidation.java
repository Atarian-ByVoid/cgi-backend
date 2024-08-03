package com.cgi.representation.validator;

import java.time.LocalDate;

import com.cgi.utils.Enum.TipoCartao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartaoDTOValidation {

    @NotBlank(message = "Numero do cartão é obrigatório", groups = CartaoValidation.Validate.class)
    private String numero;

    @NotBlank(message = "Titular do cartão é obrigatório", groups = CartaoValidation.Validate.class)
    private String titular;

    @NotNull(message = "Data de validade do cartão é obrigatório", groups = CartaoValidation.Validate.class)
    private LocalDate dataValidade;

    @NotBlank(message = "CVV do cartão é obrigatório", groups = CartaoValidation.Validate.class)
    private String cvv;

    @NotNull(message = "Tipo de cartão é obrigatório", groups = CartaoValidation.Validate.class)
    private TipoCartao tipoCartao;

    @NotBlank(message = "Documento do titular é obrigatório", groups = CartaoValidation.Validate.class)
    private String documento;

    public class CartaoValidation {

        public interface Validate {

        }
    }

}
