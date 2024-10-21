package com.codigo.examen.service.impl;

import com.codigo.examen.entity.OrderEntity;
import com.codigo.examen.entity.PersonEntity;
import com.codigo.examen.exceptions.InvalidStatusException;
import com.codigo.examen.exceptions.NotFoundException;
import com.codigo.examen.repository.OrderRepository;
import com.codigo.examen.repository.PersonRepository;
import com.codigo.examen.service.OrderService;
import com.codigo.examen.util.Constantes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PersonRepository personRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PersonRepository personRepository) {
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
    }

    @Override
    public OrderEntity createOrder(Long idPerson, OrderEntity order) {
        if (!statusValid(order.getStatus())) {
            throw new InvalidStatusException(Constantes.STATUS + Constantes.VALIDATION_ORDER_STATUS);
        }
        PersonEntity existingPerson = personRepository.findById(idPerson).orElseThrow(() -> new NotFoundException(Constantes.PERSON + Constantes.NOT_FOUND));
        order.setPerson(existingPerson);
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException(Constantes.ORDER + Constantes.NOT_FOUND));
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> getAllOrdersByStatus(String status) {
        return orderRepository.getAllByStatus(status);
    }

    @Override
    public List<OrderEntity> getByParameter(Long id, String status) {
        return orderRepository.findByIdOrStatus(id, status);
    }

    @Override
    public OrderEntity updateOrder(Long id, Long idPerson, OrderEntity order) {
        PersonEntity existingPerson = personRepository.findById(idPerson).orElseThrow(() -> new NotFoundException(Constantes.PERSON + Constantes.NOT_FOUND));
        OrderEntity existingOrder = getOrderById(id);
        existingOrder.setDescription(order.getDescription());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPerson(existingPerson);
        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        OrderEntity existingOrder = orderRepository.findByIdAndStatusNot(id, Constantes.ORDER_STATUS_DELETED).orElseThrow(() -> new NotFoundException(Constantes.ORDER + Constantes.NOT_FOUND_STATUS_NOT_DELETED));
        existingOrder.setStatus(Constantes.ORDER_STATUS_DELETED);
        orderRepository.save(existingOrder);
    }

    public boolean statusValid(String status) {
        List<String> statusList = new ArrayList<>();
        statusList.add(Constantes.ORDER_STATUS_CONFIRMED);
        statusList.add(Constantes.ORDER_STATUS_PENDING);
        statusList.add(Constantes.ORDER_STATUS_PROCESS);
        statusList.add(Constantes.ORDER_STATUS_DELETED);
        return statusList.contains(status);
    }

}
