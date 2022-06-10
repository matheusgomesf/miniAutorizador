package com.vr.miniautorizador.controller;

import com.vr.miniautorizador.domain.dao.CartaoDao;
import com.vr.miniautorizador.service.ICartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoController {

    private final ICartaoService iCartaoService;

    public CartaoController(ICartaoService iCartaoService) {
        this.iCartaoService = iCartaoService;
    }

    @PostMapping
    public ResponseEntity<CartaoDao> salvar(@RequestBody CartaoDao cartaoDao) {
        CartaoDao cartaoSave = iCartaoService.cadastrarCartao(cartaoDao);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoSave);
    }

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<BigDecimal> buscarSaldo(@PathVariable String numeroCartao ) {
        CartaoDao cartaoSave = iCartaoService.buscarCartao(numeroCartao);
        return ResponseEntity.ok(cartaoSave.getSaldoCartao());
    }
}
