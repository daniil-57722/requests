package com.example.requestTracking.repository;

import com.example.requestTracking.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByCompanyName(String name);
    List<Company> findAll();
}
