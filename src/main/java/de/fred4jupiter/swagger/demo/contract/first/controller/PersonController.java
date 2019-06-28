package de.fred4jupiter.swagger.demo.contract.first.controller;

import de.fred4jupiter.swagger.demo.contract.first.service.PersonService;
import de.fred4jupiter.swagger.generated.controller.PersonsApi;
import de.fred4jupiter.swagger.generated.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController implements PersonsApi {

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> allPersons = personService.getAllPersons();
        return ResponseEntity.ok(allPersons);
    }

    @Override
    public ResponseEntity<Void> updatePerson(@Valid Person person) {
        personService.updatePerson(person);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Person> createPerson(@Valid Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.ok(createdPerson);
    }
}
