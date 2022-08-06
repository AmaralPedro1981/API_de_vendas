package com.ampedro.vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ampedro.vendas.model.dto.VendaIn;
import com.ampedro.vendas.model.dto.VendaOut;
import com.ampedro.vendas.service.VendaService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class VendaController {

    private final VendaService vendaService;


    @PostMapping("/venda")
    public ResponseEntity<VendaOut> salvaVenda(@Valid @RequestBody VendaIn vendaIn){
        VendaOut vendaOut = vendaService.salvaVenda(vendaIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaOut);
    }

    @GetMapping("/buscarVendas/{idVendedor}")
    public List<VendaOut> buscaVendasPorIdVendedor(@PathVariable Long idVendedor){
        return vendaService.buscaVendasPorIdVendedor(idVendedor);
    }

    @GetMapping("/mediadeVendas/{idVendedor}")
    public Long mediadeVendas(@PathVariable Long idVendedor){
        Long media;
        media = vendaService.mediadeVendas(idVendedor);
        return media;
    }

}
