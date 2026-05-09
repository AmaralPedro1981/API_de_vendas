package com.ampedro.vendas.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ampedro.vendas.model.dto.VendaIn;
import com.ampedro.vendas.model.dto.VendaOut;
import com.ampedro.vendas.service.VendaService;

import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaOut> criarVenda(
            @Valid @RequestBody VendaIn vendaIn) {

        VendaOut vendaOut = vendaService.criarVenda(vendaIn);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vendaOut);
    }

    @GetMapping("/vendedor/{idVendedor}")
    public ResponseEntity<List<VendaOut>> buscarVendasPorVendedor(
            @PathVariable Long idVendedor) {

        return ResponseEntity.ok(
                vendaService.buscarVendasPorVendedor(idVendedor)
        );
    }

    @GetMapping("/vendedor/{idVendedor}/media")
    public ResponseEntity<BigDecimal> calcularMediaVendas(
            @PathVariable Long idVendedor) {

        return ResponseEntity.ok(
                vendaService.mediaDeVendas(idVendedor)
        );
    }
}