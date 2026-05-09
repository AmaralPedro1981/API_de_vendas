package com.ampedro.vendas.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaIn {

    @NotNull(message = "Id do vendedor é obrigatório")
    private Long idVendedor;

    @NotNull(message = "Data inicial é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicial;

    @NotNull(message = "Data final é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;
}