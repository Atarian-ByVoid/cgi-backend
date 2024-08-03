package com.cgi.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgi.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {

    @Query("""
            SELECT c
            FROM Cartao c
            JOIN FETCH c.usuario u
            WHERE u.documento = :documento
            AND c.cvv = :cvv
            AND c.numero = :numero
            AND c.dataValidade = :dataValidade
            AND c.titular = :titular
                    """)
    Optional<Cartao> validarCartao(String cvv, String numero, LocalDate dataValidade, String titular, String documento);

}
