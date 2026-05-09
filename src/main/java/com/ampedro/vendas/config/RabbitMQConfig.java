package com.ampedro.vendas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PEDIDOS = "pedidos.queue";

    @Bean
    public Queue filaPedidos() {
        return new Queue(FILA_PEDIDOS, true);
    }
}