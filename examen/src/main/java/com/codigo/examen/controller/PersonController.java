package com.codigo.examen.controller;

import com.codigo.examen.entity.PersonEntity;
import com.codigo.examen.service.PersonService;
import com.codigo.examen.util.Constantes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas/v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/crearPersona")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody PersonEntity person) {
        PersonEntity newPerson = personService.savePerson(person);
        return ResponseEntity.status(Constantes.STATUS_201).body(newPerson);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PersonEntity>> getPersons() {
        List<PersonEntity> foundPersons = personService.getAllActivePersons(Constantes.PERSON_STATUS_ACTIVE);
        return ResponseEntity.status(Constantes.STATUS_200).body(foundPersons);
    }

    @GetMapping("/buscarPersonaXnumDocumento")
    public ResponseEntity<PersonEntity> findByIdNumber(@RequestParam(required = true) String numDocumento) {
        PersonEntity person = personService.getPersonByIdNumber(numDocumento);
        return ResponseEntity.status(Constantes.STATUS_200).body(person);
    }

    @PutMapping("/actualizarPersona/{id}")
    public ResponseEntity<PersonEntity> updatePerson(@PathVariable Long id, @RequestBody PersonEntity person) {
        PersonEntity updatedPerson = personService.updatePerson(id, person);
        return ResponseEntity.status(Constantes.STATUS_200).body(updatedPerson);
    }

    @DeleteMapping("/eliminarPersona/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.status(Constantes.STATUS_209).body(Constantes.PERSON + Constantes.ENTITY_DELETED + id);
    }

}
