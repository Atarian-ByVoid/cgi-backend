package com.cgi.representation.validator;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TransacaoDTOValidation {

    @NotBlank(message = "Valor da transação é obrigatório", groups = TransacaoValidation.ParaTransacao.class)
    private String valorTransacao;

    private CartaoDTOValidation cartaoDTOValidation = new CartaoDTOValidation();

    public class TransacaoValidation {

        public interface ParaTransacao {

        }
    }

}
