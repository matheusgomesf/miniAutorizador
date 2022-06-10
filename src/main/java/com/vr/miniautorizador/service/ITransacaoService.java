package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.dao.CartaoDao;
import com.vr.miniautorizador.domain.dao.TransacaoDao;

public interface ITransacaoService {
    CartaoDao cadastrar(TransacaoDao transacaoDao);
}
