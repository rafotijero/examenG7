package com.codigo.examen.service;

import com.codigo.examen.entity.OrderEntity;
import com.codigo.examen.entity.PersonEntity;
import org.hibernate.query.Order;

import java.util.List;

public interface OrderService {

    OrderEntity createOrder(Long idPerson, OrderEntity orderEntity);
    OrderEntity getOrderById(Long id);
    List<OrderEntity> getAllOrders();
    List<OrderEntity> getAllOrdersByStatus(String status);
    List<OrderEntity> getByParameter(Long id, String status);
    OrderEntity updateOrder(Long id, Long idPerson, OrderEntity orderEntity);
    void deleteOrder(Long id);

}
