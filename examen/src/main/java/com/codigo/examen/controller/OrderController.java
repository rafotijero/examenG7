package com.codigo.examen.controller;

import com.codigo.examen.entity.OrderEntity;
import com.codigo.examen.service.OrderService;
import com.codigo.examen.util.Constantes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/crearPedido/persona/{idPerson}")
    public ResponseEntity<OrderEntity> createOrder(@PathVariable Long idPerson, @Valid @RequestBody OrderEntity order) {
        OrderEntity newOrder = orderService.createOrder(idPerson, order);
        return ResponseEntity.status(Constantes.STATUS_201).body(newOrder);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<OrderEntity>> getAllOrders(@RequestParam(required = true) String estado) {
        List<OrderEntity> foundOrders = orderService.getAllOrdersByStatus(estado);
        return ResponseEntity.status(Constantes.STATUS_200).body(foundOrders);
    }

    @GetMapping("/buscarPedidoPorParametro")
    public ResponseEntity<List<OrderEntity>> findOrderByParameter(@RequestParam(required = false) Long id, @RequestParam(required = false) String estado) {
        List<OrderEntity> foundOrders = orderService.getByParameter(id, estado);
        return ResponseEntity.status(Constantes.STATUS_200).body(foundOrders);
    }

    @PutMapping("/actualizarPedido/{id}/persona/{idPerson}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @PathVariable Long idPerson, @RequestBody OrderEntity order) {
        OrderEntity updatedOrder = orderService.updateOrder(id, idPerson, order);
        return ResponseEntity.status(Constantes.STATUS_200).body(updatedOrder);
    }

    @DeleteMapping("/eliminarPedido/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.status(Constantes.STATUS_209).body(Constantes.ORDER + Constantes.ENTITY_DELETED + id);
    }

}
