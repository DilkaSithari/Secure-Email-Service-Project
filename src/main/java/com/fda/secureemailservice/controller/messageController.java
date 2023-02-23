package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/send")
public class messageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("getusernames")
    public List<String> getAllUserNames(){
        return messageRepository.getAllUserNames();
    }

}
