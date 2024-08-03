package com.cgi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, UUID> {

    @EntityGraph(attributePaths = "usuario")
    List<Aposta> findAll();

}
