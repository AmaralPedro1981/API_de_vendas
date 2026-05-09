package com.ampedro.vendas.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;




@Getter
public class VendedorIn {


    @NotBlank
    private String nome;


}
