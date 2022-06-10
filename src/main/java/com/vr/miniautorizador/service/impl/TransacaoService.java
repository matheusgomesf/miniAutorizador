package com.vr.miniautorizador.service.impl;

import com.vr.miniautorizador.domain.dao.CartaoDao;
import com.vr.miniautorizador.domain.dao.TransacaoDao;
import com.vr.miniautorizador.exceptions.SaldoInsuficienteException;
import com.vr.miniautorizador.service.ICartaoService;
import com.vr.miniautorizador.service.ITransacaoService;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements ITransacaoService {

    private final ICartaoService iCartaoService;

    public TransacaoService(ICartaoService iCartaoService) {
        this.iCartaoService = iCartaoService;
    }

    @Override
    public CartaoDao cadastrar(TransacaoDao transacaoDao) {
        CartaoDao cartaoDao = iCartaoService.buscarCartao(transacaoDao.getNumeroCartao());
        iCartaoService.validarSenhaCartao(cartaoDao, transacaoDao.getSenha());

        if (cartaoDao.getSaldoCartao().compareTo(transacaoDao.getValor()) <= 0)
            throw new SaldoInsuficienteException();

        cartaoDao.setSaldoCartao(cartaoDao.getSaldoCartao().subtract(transacaoDao.getValor()));
        iCartaoService.atualizarCartao(cartaoDao);

        return cartaoDao;
    }
}
