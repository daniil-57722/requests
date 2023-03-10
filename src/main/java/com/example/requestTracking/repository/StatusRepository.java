package com.example.requestTracking.repository;

import com.example.requestTracking.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
    Status findByStatusName(String name);
}
