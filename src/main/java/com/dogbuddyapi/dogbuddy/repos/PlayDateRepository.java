package com.dogbuddyapi.dogbuddy.repos;

import com.dogbuddyapi.dogbuddy.entities.PlayDate;
import com.dogbuddyapi.dogbuddy.entities.Response;
import org.aspectj.apache.bcel.util.Play;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayDateRepository extends CrudRepository<PlayDate, Long> {
    List<PlayDate> findByStatus(@Param("status")Response status);

}
