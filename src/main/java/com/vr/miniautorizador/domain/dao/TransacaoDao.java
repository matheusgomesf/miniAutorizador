package com.vr.miniautorizador.domain.dao;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransacaoDao {
    private String numeroCartao;
    private String senha;
    private BigDecimal valor;
}
