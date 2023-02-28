package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.repository.impl.MessageRepositoryImpl;
import com.fda.secureemailservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/usernames")
    public List<String> getAllUserNames(){
        return messageService.getAllUserNames();
    }
    @GetMapping("/getEmail")
    public String getEmailByUserName(@RequestParam("username") String username){
        return messageService.getEmailByUserName(username);
    }


}
