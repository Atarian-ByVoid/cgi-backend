package com.cgi.model;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Usuario extends AbstractEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    @JsonProperty("password")
    private String password;

    private boolean disabled;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id", nullable = false)
    private Telefone telefone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Investimento> investimentos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Aposta> apostas;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cartao cartao;

    public void encryptPassword() {
        if (password != null) {
            this.password = BCrypt.hashpw(this.password, BCrypt.gensalt());
        }
    }

}
