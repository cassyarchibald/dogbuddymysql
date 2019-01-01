package com.dogbuddyapi.dogbuddy.repos;

import com.dogbuddyapi.dogbuddy.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
