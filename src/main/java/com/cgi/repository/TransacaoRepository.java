package com.cgi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

}
