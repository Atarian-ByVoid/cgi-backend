package com.cgi.model;

import com.cgi.utils.Enum.TipoTransacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Transacao extends AbstractEntity {

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Column(nullable = false)
    private Double valorTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta", referencedColumnName = "id")
    private Conta conta;

}