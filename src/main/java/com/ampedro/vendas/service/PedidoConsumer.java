package com.ampedro.vendas.service;

import com.ampedro.vendas.model.dto.Entrega;
import com.ampedro.vendas.model.dto.PedidoMessage;
import com.ampedro.vendas.repository.EntregaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoConsumer {

    private final EntregaRepository entregaRepository;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumirPedido(PedidoMessage message) {

        Entrega entrega = Entrega.builder()
                .pedidoId(message.getPedidoId())
                .enderecoEntrega(message.getEnderecoEntrega())
                .build();

        entregaRepository.save(entrega);

        System.out.println("Entrega criada com sucesso!");
    }
}