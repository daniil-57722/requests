package com.example.requestTracking.repository;

import com.example.requestTracking.entity.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
