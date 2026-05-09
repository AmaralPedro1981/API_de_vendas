package com.ampedro.vendas.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.ampedro.vendas.model.Venda;
import com.ampedro.vendas.model.dto.ConsultaIn;
import com.ampedro.vendas.model.dto.VendaOut;
import com.ampedro.vendas.repository.VendaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaService {

    private final VendaRepository vendaRepository;

    public List<VendaOut> buscarVendasPorDatas(ConsultaIn consultaIn) {

        List<Venda> vendaList =
                vendaRepository.findByIdVendedor(
                        consultaIn.getIdVendedor());

        List<VendaOut> list = new ArrayList<>();

        LocalDate dataInicial = consultaIn.getDataInicial();
        LocalDate dataFinal = consultaIn.getDataFinal();

        vendaList.forEach(venda -> {

            LocalDate dataVenda = venda.getData();

            if ((dataVenda.isEqual(dataInicial)
                    || dataVenda.isAfter(dataInicial))
                    &&
                    (dataVenda.isEqual(dataFinal)
                            || dataVenda.isBefore(dataFinal))) {

                VendaOut vendaOut = new VendaOut();

                vendaOut.setIdVenda(venda.getIdVenda());
                vendaOut.setIdVendedor(venda.getVendedor().getId());
                vendaOut.setNomeVendendor(venda.getVendedor().getNome());
                vendaOut.setValor(venda.getValor());
                vendaOut.setData(venda.getData());

                list.add(vendaOut);
            }
        });

        return list;
    }

    public BigDecimal mediaPorDatas(ConsultaIn consultaIn) {

        List<Venda> vendaList =
                vendaRepository.findByIdVendedor(
                        consultaIn.getIdVendedor());

        List<BigDecimal> media = new ArrayList<>();

        LocalDate dataInicial = consultaIn.getDataInicial();
        LocalDate dataFinal = consultaIn.getDataFinal();

        vendaList.forEach(venda -> {

            LocalDate dataVenda = venda.getData();

            if ((dataVenda.isEqual(dataInicial)
                    || dataVenda.isAfter(dataInicial))
                    &&
                    (dataVenda.isEqual(dataFinal)
                            || dataVenda.isBefore(dataFinal))) {

                media.add(venda.getValor());
            }
        });

        if (media.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal soma = BigDecimal.ZERO;

        for (BigDecimal valor : media) {
            soma = soma.add(valor);
        }

        return soma.divide(BigDecimal.valueOf(media.size()));
    }
}