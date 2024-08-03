package com.cgi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {

}
