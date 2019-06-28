package de.fred4jupiter.swagger.demo.contract.first.service;

import de.fred4jupiter.swagger.generated.model.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

@Service
public class PersonService {

    private final List<Person> persons = new ArrayList<>();

    @PostConstruct
    void init() {
        persons.add(new Person().id(1).firstname("John").lastname("Smith").age(42));
        persons.add(new Person().id(2).firstname("Jane").lastname("Jonhnson").age(19));
        persons.add(new Person().id(3).firstname("Kate").lastname("Jones").age(33));
    }

    public List<Person> getAllPersons() {
        return this.persons;
    }

    public Person getPersonById(Integer id) {
        return this.persons
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Person createPerson(Person person) {
        OptionalInt maxId = this.persons.stream().mapToInt(Person::getId).max();
        if (maxId.isPresent()) {
            person.setId(maxId.getAsInt() + 1);
        }

        this.persons.add(person);
        return person;
    }

    public void deletePerson(int id) {
        this.persons.removeIf(person -> person.getId().equals(id));
    }

    public void updatePerson(Person person) {
        Person updatePerson = getPersonById(person.getId());
        updatePerson.setFirstname(person.getFirstname());
        updatePerson.setLastname(person.getLastname());
        updatePerson.setAge(person.getAge());
    }

    public boolean existsId(Integer id) {
        return this.persons.stream().filter(person -> person.getId().equals(id)).count() > 0;
    }
}
