package com.cassandra.cassandracrud.service;

import com.cassandra.cassandracrud.model.Person;
import com.cassandra.cassandracrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        List<Person>persons=new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public Person findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person updatePerson(Person newPerson) {
       Person person=personRepository.findById(newPerson.getId()).orElse(null);
       if(Objects.nonNull(person)){
           person.setId(newPerson.getId());
           person.setAge(newPerson.getAge());
           person.setName(newPerson.getName());
           personRepository.save(person);
       }
        return person;
    }

    public String deletePerson(String id) {
        Person person=personRepository.findById(id).orElse(null);
        if(Objects.nonNull(person)){
            personRepository.delete(person);
            return "Person deleted";
        }
        return "Person not exist";
    }

    public Person createPerson(Person newPerson) {
        String id = String.valueOf(new Random().nextInt());
        Person person=Person.builder().id(id).name(newPerson.getName()).age(newPerson.getAge()).build();
        personRepository.save(person);
        return person;
    }
}
