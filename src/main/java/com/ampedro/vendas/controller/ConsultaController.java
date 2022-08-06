package com.ampedro.vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ampedro.vendas.model.dto.ConsultaIn;
import com.ampedro.vendas.model.dto.VendaOut;
import com.ampedro.vendas.service.ConsultaService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ConsultaController {

    private final ConsultaService consultaService;


    @PostMapping("/buscarVendasPorDatas/")
    public ResponseEntity<List<VendaOut>> buscarVendasPorDatas(@Valid @RequestBody ConsultaIn consultaIn){
        List<VendaOut> vendaOut = consultaService.buscarVendasPorDatas(consultaIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaOut);
    }

    @PostMapping("/mediaPorDatas/")
    public ResponseEntity<Long> mediaPorDatas(@Valid @RequestBody ConsultaIn consultaIn){
       Long mediaPorDatas = consultaService.mediaPorDatas(consultaIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(mediaPorDatas);
    }
    
}