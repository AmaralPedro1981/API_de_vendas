package com.ampedro.vendas.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ampedro.vendas.model.Vendedor;
import com.ampedro.vendas.model.dto.VendedorIn;
import com.ampedro.vendas.repository.VendedorRepository;

@RequiredArgsConstructor
@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final ModelMapper modelMapper;

    public void salvaVendedor(VendedorIn vendedorIn){
        Vendedor vendedor = modelMapper.map(vendedorIn, Vendedor.class);
        vendedorRepository.save(vendedor);
    }

}
