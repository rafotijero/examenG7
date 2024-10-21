package com.codigo.examen.service;

import com.codigo.examen.entity.PersonEntity;

import java.util.List;

public interface PersonService {

    PersonEntity savePerson(PersonEntity person);
    PersonEntity getPersonById(Long id);

    PersonEntity getPersonByIdNumber(String idNumber);
    List<PersonEntity> getAllPersons();
    List<PersonEntity> getAllActivePersons(String status);
    PersonEntity updatePerson(Long id, PersonEntity person);
    void deletePerson(Long id);

}
