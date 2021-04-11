package com.cassandra.cassandracrud.service;

import com.cassandra.cassandracrud.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person findById(Long id);

    Person updatePerson(Person newPerson);

    String deletePerson(Long id);

    Person createPerson(Person newPerson);
}
