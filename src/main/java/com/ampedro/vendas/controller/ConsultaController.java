package com.ampedro.vendas.controller;

import com.ampedro.vendas.model.dto.ConsultaIn;
import com.ampedro.vendas.model.dto.VendaOut;
import com.ampedro.vendas.service.ConsultaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping("/vendas")
    public ResponseEntity<List<VendaOut>> buscarVendas(
            @Valid @RequestBody ConsultaIn consultaIn) {

        return ResponseEntity.ok(
                consultaService.buscarVendasPorDatas(consultaIn)
        );
    }

    @PostMapping("/vendas/media")
    public ResponseEntity<BigDecimal> calcularMedia(
            @Valid @RequestBody ConsultaIn consultaIn) {

        return ResponseEntity.ok(
                consultaService.mediaPorDatas(consultaIn)
        );
    }
}