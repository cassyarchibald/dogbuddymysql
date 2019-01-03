package com.dogbuddyapi.dogbuddy.repos;

import com.dogbuddyapi.dogbuddy.entities.PlayDate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayDateRepository extends PagingAndSortingRepository<PlayDate, Long> {
}
