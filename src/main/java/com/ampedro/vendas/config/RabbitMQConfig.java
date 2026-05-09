package com.ampedro.vendas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String FILA_PEDIDO = "pedido.queue";

    @Bean
    public Queue queue() {
        return new Queue(FILA_PEDIDO, true);
    }
}