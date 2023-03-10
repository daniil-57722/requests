package com.example.requestTracking.controller;

import com.example.requestTracking.entity.Journal;
import com.example.requestTracking.entity.User;
import com.example.requestTracking.repository.CompanyRepository;
import com.example.requestTracking.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalService journalService;

    @Autowired
    CompanyRepository companyRepository;


    @PostMapping("/add")
    public String addJournal(@RequestParam String journalName, @AuthenticationPrincipal User user){
        Journal journal = new Journal();
        journal.setUser(user);
        journal.setName(journalName);
        journalService.saveJournal(journal);
        return "redirect:/main";
    }

    /**
     * @param journal journal by id
     * @param model
     * @return journal page
     */
    @GetMapping("/{journal}")
    public String openJournal(@PathVariable Journal journal, Model model){
        model.addAttribute("requests", journal.getRequestList());
        model.addAttribute("journal", journal);
        model.addAttribute("companies", companyRepository.findAll());
        companyRepository.findAll().forEach(c-> System.out.println(c.getCompanyName()));
        return "journal";
    }

}
