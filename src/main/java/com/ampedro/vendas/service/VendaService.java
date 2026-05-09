package com.ampedro.vendas.service;

import com.ampedro.vendas.config.PedidoProducer;
import com.ampedro.vendas.model.dto.PedidoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ampedro.vendas.model.Venda;
import com.ampedro.vendas.model.Vendedor;
import com.ampedro.vendas.model.dto.VendaIn;
import com.ampedro.vendas.model.dto.VendaOut;
import com.ampedro.vendas.repository.VendaRepository;
import com.ampedro.vendas.repository.VendedorRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;
    private final PedidoProducer pedidoProducer;

    public VendaOut criarVenda(VendaIn vendaIn) {

        Vendedor vendedor = vendedorRepository.findById(vendaIn.getIdVendedor())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Vendedor não encontrado"
                        ));

        Venda venda = new Venda(
                null,
                vendedor,
                vendedor.getNome(),
                vendaIn.getData(),
                vendaIn.getValor(),
                vendaIn.getEnderecoEntrega()
        );

        venda = vendaRepository.save(venda);

        PedidoMessage message = PedidoMessage.builder()
                .pedidoId(venda.getIdVenda())
                .enderecoEntrega(venda.getEnderecoEntrega())
                .build();

        pedidoProducer.enviarPedido(message);

        return new VendaOut(
                venda.getIdVenda(),
                vendedor.getId(),
                vendedor.getNome(),
                venda.getValor(),
                venda.getData()
        );
    }

    public List<VendaOut> buscarVendasPorVendedor(Long idVendedor) {

        List<Venda> vendaList =
                vendaRepository.findByIdVendedor(idVendedor);

        return vendaList.stream()
                .map(venda -> new VendaOut(
                        venda.getIdVenda(),
                        venda.getVendedor().getId(),
                        venda.getVendedor().getNome(),
                        venda.getValor(),
                        venda.getData()
                ))
                .collect(Collectors.toList());
    }

    public BigDecimal mediaDeVendas(Long idVendedor) {

        List<Venda> vendaList =
                vendaRepository.findByIdVendedor(idVendedor);

        if (vendaList.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal soma = vendaList.stream()
                .map(Venda::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return soma.divide(BigDecimal.valueOf(vendaList.size()));
    }
}