package com.cgi.model;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cgi.utils.Enum.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conta", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Conta extends AbstractEntity {

    @Column(nullable = true)
    private Double saldo;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @JsonIgnore
    @OneToOne(mappedBy = "conta", fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy = "conta", fetch = FetchType.LAZY)
    private List<Transacao> transacao;

}
