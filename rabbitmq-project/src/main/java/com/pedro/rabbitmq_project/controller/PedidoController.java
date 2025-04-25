package com.pedro.rabbitmq_project.controller;

import com.pedro.rabbitmq_project.model.Pedido;
import com.pedro.rabbitmq_project.publisher.PedidoPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoPublisher pedidoPublisher;

    public PedidoController(PedidoPublisher pedidoPublisher) {
        this.pedidoPublisher = pedidoPublisher;
    }

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        pedidoPublisher.enviarPedido(pedido);
        return "Pedido enviado para processamento!";
    }
}

