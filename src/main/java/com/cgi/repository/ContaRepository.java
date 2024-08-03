package com.cgi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Conta;
import com.cgi.model.Usuario;

public interface ContaRepository extends JpaRepository<Conta, UUID> {

    Conta findByUsuario(Usuario usuario);

}
