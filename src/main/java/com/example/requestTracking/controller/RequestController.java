package com.example.requestTracking.controller;

import com.example.requestTracking.dto.RequestDto;
import com.example.requestTracking.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @PostMapping("/save")
    public String saveRequest(RequestDto requestDto){
        requestService.saveRequest(requestDto);
        return "redirect:/journal/"+requestDto.getIdJournal();
    }
    @PostMapping("/delete")
    public String deleteRequest(@RequestParam Long idRequest, @RequestParam String idJournal){
        requestService.deleteRequest(idRequest);
        return "redirect:/journal/"+idJournal;
    }
    @PostMapping("/done")
    public String closeRequest(@RequestParam Long idRequest, @RequestParam String idJournal){
        requestService.closeRequest(idRequest);
        return "redirect:/journal/"+idJournal;
    }



}
