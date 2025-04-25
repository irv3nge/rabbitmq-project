package com.pedro.rabbitmq_project.publisher;

import com.pedro.rabbitmq_project.config.RabbitMQConfig;
import com.pedro.rabbitmq_project.model.Pedido;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PedidoPublisher {

    private final RabbitTemplate rabbitTemplate;

    public PedidoPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, pedido);
    }
}

