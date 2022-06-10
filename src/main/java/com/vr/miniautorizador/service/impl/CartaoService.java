package com.vr.miniautorizador.service.impl;

import com.vr.miniautorizador.domain.CartaoEntity;
import com.vr.miniautorizador.domain.dao.CartaoDao;
import com.vr.miniautorizador.exceptions.CartaoExistenteException;
import com.vr.miniautorizador.exceptions.SenhaInvalidaException;
import com.vr.miniautorizador.mapper.CartaoMapper;
import com.vr.miniautorizador.repository.CartaoRepository;
import com.vr.miniautorizador.service.ICartaoService;
import org.springframework.stereotype.Service;

@Service
public class CartaoService implements ICartaoService {

    private final CartaoRepository repository;
    private final CartaoMapper mapper;

    public CartaoService(CartaoRepository repository, CartaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CartaoDao cadastrarCartao(CartaoDao cartaoDao) {

        repository.findByNumeroCartao(cartaoDao.getNumeroCartao()).ifPresent(cartao -> {
            throw new CartaoExistenteException("Cartão "+cartao.getNumeroCartao()+" já existe");
        });
        CartaoEntity save = repository.save(mapper.dtoToEntity(cartaoDao));
        return mapper.entityToDto(save);
    }

    @Override
    public CartaoDao atualizarCartao(CartaoDao cartaoDao) {
        CartaoEntity save = repository.save(mapper.dtoToEntity(cartaoDao));
        return mapper.entityToDto(save);
    }

    @Override
    public CartaoDao buscarCartao(String numeroCartao) {
        CartaoEntity cartaoEntity = repository.findByNumeroCartao(numeroCartao)
                .orElseThrow(() -> new CartaoExistenteException("Cartão " + numeroCartao + " não existe"));

        return mapper.entityToDto(cartaoEntity);
    }

    @Override
    public void validarSenhaCartao(CartaoDao cartaoDao, String senha) {
        if (!cartaoDao.getSenha().equals(senha)) {
            throw new SenhaInvalidaException();
        }
    }
}
