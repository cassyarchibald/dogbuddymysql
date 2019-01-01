package com.dogbuddyapi.dogbuddy.repos;

import com.dogbuddyapi.dogbuddy.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
