package com.pedro.rabbitmq_project.consumer;

import com.pedro.rabbitmq_project.model.Pedido;
import com.pedro.rabbitmq_project.repository.PedidoRepository;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {

    private final PedidoRepository pedidoRepository;

    public PedidoConsumer(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @RabbitListener(queues = "pedidos.novos")
    public void receberPedido(Pedido pedido) {
        System.out.println("Pedido recebido: " + pedido);

        if (pedido.getValor() < 1000.00) {
            System.out.println("Pedido inválido! Valor abaixo do permitido.");
            throw new AmqpRejectAndDontRequeueException("Pedido inválido");
        }

        pedidoRepository.save(pedido);
        System.out.println("Pedido salvo no banco: " + pedido.getId());
    }
}
