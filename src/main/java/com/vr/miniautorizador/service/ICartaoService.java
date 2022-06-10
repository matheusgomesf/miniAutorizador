package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.dao.CartaoDao;

public interface ICartaoService {
    CartaoDao cadastrarCartao(CartaoDao cartaoDao);

    CartaoDao atualizarCartao(CartaoDao cartaoDao);

    CartaoDao buscarCartao(String numeroCartao);

    void validarSenhaCartao(CartaoDao cartaoDao, String senha);
}
