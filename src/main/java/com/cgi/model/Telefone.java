package com.cgi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cgi.utils.Enum.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "telefones", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id" }) })
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
public class Telefone extends AbstractEntity {

    @Column(length = 15, nullable = false)
    private String numero;

    @Column(name = "tipo", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @Column(name = "ramal", columnDefinition = "VARCHAR(15) DEFAULT NULL")
    private String ramal;

    @JsonIgnore
    @OneToOne(mappedBy = "telefone", fetch = FetchType.LAZY)
    private Usuario usuario;

}
