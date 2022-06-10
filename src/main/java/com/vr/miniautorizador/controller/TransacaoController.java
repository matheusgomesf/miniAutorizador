package com.vr.miniautorizador.controller;

import com.vr.miniautorizador.domain.dao.TransacaoDao;
import com.vr.miniautorizador.service.ITransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoController {

    private final ITransacaoService iTransacaoService;

    public TransacaoController(ITransacaoService iTransacaoService) {
        this.iTransacaoService = iTransacaoService;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody TransacaoDao transacaoDao) {
        iTransacaoService.cadastrar(transacaoDao);
        return ResponseEntity.ok().build();
    }
}
