package com.cassandra.cassandracrud.repository;

import com.cassandra.cassandracrud.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,String> {
}
