package com.ampedro.vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ampedro.vendas.model.dto.VendedorIn;
import com.ampedro.vendas.model.dto.VendedorOut;
import com.ampedro.vendas.service.VendedorService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class VendedorController {

    private final VendedorService vendedorService;

    @PostMapping("/vendedor")
    public ResponseEntity salvarVendedor(@Valid @RequestBody VendedorIn vendedorIn){
       vendedorService.salvaVendedor(vendedorIn);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
