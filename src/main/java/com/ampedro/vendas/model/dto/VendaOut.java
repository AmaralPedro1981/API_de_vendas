package com.ampedro.vendas.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaOut {

    private Long idVenda;
    private Long idVendedor;
    private String nomeVendendor;
    private BigDecimal valor;
    private LocalDate data;


   }
