package com.codigo.examen.service.impl;

import com.codigo.examen.entity.OrderEntity;
import com.codigo.examen.entity.PersonEntity;
import com.codigo.examen.exceptions.InvalidStatusException;
import com.codigo.examen.exceptions.NotFoundException;
import com.codigo.examen.repository.OrderRepository;
import com.codigo.examen.repository.PersonRepository;
import com.codigo.examen.service.PersonService;
import com.codigo.examen.util.Constantes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final OrderRepository orderRepository;

    public PersonServiceImpl(PersonRepository personRepository, OrderRepository orderRepository) {
        this.personRepository = personRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public PersonEntity savePerson(PersonEntity person) {
        if (person.getStatus().equals(Constantes.PERSON_STATUS_ACTIVE) || person.getStatus().equals(Constantes.PERSON_STATUS_INACTIVE))
            return personRepository.save(person);
        else
            throw new InvalidStatusException(Constantes.STATUS + Constantes.VALIDATION_PERSON_STATUS);
    }

    @Override
    public PersonEntity getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException(Constantes.PERSON + Constantes.NOT_FOUND));
    }

    @Override
    public PersonEntity getPersonByIdNumber(String idNumber) {
        return personRepository.findByIdNumber(idNumber).orElseThrow(()->new NotFoundException(Constantes.PERSON + Constantes.NOT_FOUND));
    }

    @Override
    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<PersonEntity> getAllActivePersons(String status) {
        return personRepository.getAllByStatus(status);
    }

    @Override
    public PersonEntity updatePerson(Long id, PersonEntity person) {
        PersonEntity existingPerson = this.getPersonById(id);
        existingPerson.setName(person.getName());
        existingPerson.setIdNumber(person.getIdNumber());
        existingPerson.setAddressEntity(person.getAddressEntity());
        manageOrders(existingPerson, person.getOrders());
        return personRepository.save(existingPerson);
    }

    private void manageOrders(PersonEntity existingPerson, List<OrderEntity> updatesOrders) {
        List<OrderEntity> existingOrders = existingPerson.getOrders();
        existingOrders.clear();

        for(OrderEntity order: updatesOrders) {
            if (order.getId() != null) {
                OrderEntity orderFound = orderRepository.findById(order.getId()).orElseThrow(() -> new NotFoundException(Constantes.ORDER + Constantes.NOT_FOUND));
                orderFound.setDescription(order.getDescription());
                orderFound.setQuantity(order.getQuantity());
                orderFound.setStatus(order.getStatus());
                existingOrders.add(orderFound);
            } else {
                order.setPerson(existingPerson);
                existingOrders.add(order);
            }
        }
    }

    @Override
    public void deletePerson(Long id) {
        PersonEntity person = personRepository.findByIdAndStatus(id, Constantes.PERSON_STATUS_ACTIVE).orElseThrow(() -> new NotFoundException(Constantes.PERSON + Constantes.NOT_FOUND_STATUS_ACTIVE));
        person.setStatus(Constantes.PERSON_STATUS_INACTIVE);
        personRepository.save(person);
    }

}
