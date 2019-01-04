package com.dogbuddyapi.dogbuddy.repos;

import com.dogbuddyapi.dogbuddy.entities.Dog;
import com.dogbuddyapi.dogbuddy.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    List<Dog> findByName(@Param("name") String name);
    List<Dog> findByBreed(@Param("breed") String breed);


}
