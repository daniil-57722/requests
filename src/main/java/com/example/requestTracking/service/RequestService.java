package com.example.requestTracking.service;

import com.example.requestTracking.dto.RequestDto;
import com.example.requestTracking.entity.Company;
import com.example.requestTracking.entity.Request;
import com.example.requestTracking.repository.CompanyRepository;
import com.example.requestTracking.repository.JournalRepository;
import com.example.requestTracking.repository.RequestRepository;
import com.example.requestTracking.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class RequestService {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    JournalRepository journalRepository;

    @Autowired
    StatusRepository statusRepository;

    public void saveRequest(RequestDto requestDto){

        Request request = ObjectMapper.map(requestDto, Request.class);
        request.setStatus(statusRepository.findByStatusName("Открыт"));
        Company company = companyRepository.findByCompanyName(requestDto.getCompanyName());
        if(company==null){
            company=new Company(requestDto.getCompanyName());
            companyRepository.save(company);
        }
        request.setCompany(company);
        request.setJournal(journalRepository.findById(requestDto.getIdJournal()).orElse(null));
        request.setRequestDate(Date.valueOf(LocalDate.now()));
        String[] requester = requestDto.getRequester().split(" ");
        request.setRequesterFirstname(requester[0]);
        request.setRequesterMiddlename(requester[1]);
        request.setRequesterLastname(requester[2]);
        requestRepository.save(request);
    }

    public void deleteRequest(Long idRequest) {
        requestRepository.deleteById(idRequest);
    }

    public void closeRequest(Long idRequest) {
        Request request = requestRepository.findById(idRequest).orElse(null);
        assert request != null;
        request.setStatus(statusRepository.findByStatusName("Завершён"));
        requestRepository.save(request);
    }
}
