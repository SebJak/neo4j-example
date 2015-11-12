package com.example;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Sebastian on 2015-11-07.
 */
@Repository
public interface PersonRepository extends GraphRepository<Person> {

    Collection<Person> findByFirstName(String firstName);

    Person findByNick(String nick);
}
