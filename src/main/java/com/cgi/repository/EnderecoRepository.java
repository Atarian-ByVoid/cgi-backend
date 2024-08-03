package com.cgi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
