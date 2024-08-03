package com.cgi.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.cgi.model.Usuario;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    UserDetails findByEmail(String email);

    @Query("""
            SELECT NEW com.cgi.representation.AuthDetails(
            u.id, u.disabled, u.email, u.password
            )
            FROM Usuario u
            WHERE LOWER(u.email) = LOWER(:email)
            """)
    UserDetails loadUserByUsername(@Param("email") String email);

    List<Usuario> findAllByApostasIsNotNull();

    @Query("""
            SELECT u
                FROM Usuario u
                JOIN FETCH u.conta
                WHERE u.id = :accountId

                """)
    Optional<Usuario> findByIdJoinConta(UUID accountId);

    @Query("""
            SELECT u
                FROM Usuario u
                JOIN FETCH u.conta
                WHERE u.documento = :cpf

                """)
    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findById(UUID requestedUserId);

}