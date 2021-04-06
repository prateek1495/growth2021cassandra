package com.cassandra.cassandracrud.controller;

import com.cassandra.cassandracrud.model.Person;
import com.cassandra.cassandracrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.findById(id);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person newPerson) {
        return personService.updatePerson(newPerson);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        return personService.deletePerson(id);
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody Person newPerson) {
        return personService.createPerson(newPerson);
    }
}
