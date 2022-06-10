package com.vr.miniautorizador.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "cartao")
public class CartaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numeroCartao")
    private String numeroCartao;

    @Column(name = "senha")
    private String senha;

    @Column(name = "saldoCartao")
    private BigDecimal saldoCartao;

    @PrePersist
    private void prePersist() {
        this.saldoCartao = BigDecimal.valueOf(500);
    }
}
