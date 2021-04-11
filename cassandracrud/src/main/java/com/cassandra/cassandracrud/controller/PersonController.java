package com.cassandra.cassandracrud.controller;

import com.cassandra.cassandracrud.model.Person;
import com.cassandra.cassandracrud.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping("/")
    public List<Person> getPersons() {
        return personServiceImpl.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personServiceImpl.findById(id);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person newPerson) {
        return personServiceImpl.updatePerson(newPerson);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        return personServiceImpl.deletePerson(id);
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody Person newPerson) {
        return personServiceImpl.createPerson(newPerson);
    }
}
