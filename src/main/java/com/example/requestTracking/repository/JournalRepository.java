package com.example.requestTracking.repository;

import com.example.requestTracking.entity.Journal;
import com.example.requestTracking.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Long> {
    List<Journal> findAllByUser(User user);
}
