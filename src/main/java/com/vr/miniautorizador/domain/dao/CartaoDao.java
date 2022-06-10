package com.vr.miniautorizador.domain.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDao {
    @JsonIgnore
    private Long id;
    private String numeroCartao;
    private String senha;
    private BigDecimal saldoCartao;
}
