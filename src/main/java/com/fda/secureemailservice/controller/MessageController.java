package com.fda.secureemailservice.controller;
import com.fda.secureemailservice.model.EmailDetails;
import com.fda.secureemailservice.service.MessageService;
import com.fda.secureemailservice.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/service")

public class MessageController {
    @Autowired
    EmailUtil emailUtil;

    @Autowired
    MessageService messageService;

    @GetMapping("/usernames")
    public List<String> getAllUserNames(){
        return messageService.getAllUserNames();
    }
    @GetMapping("/getDetails/{userName}")
    public ResponseEntity<Object> getDetailsByUserName(@PathVariable("userName") String userName) {
        ResponseEntity<Object> getDetailsByUserName= messageService.getDetailsByUserName(userName);
        return getDetailsByUserName;
    }



//    @GetMapping( "/sendemail/{userName}")
//    public String sendmail(@PathVariable("userName") String userName)    {
//
//        List<EmailDetails> list = messageService.getDetailsByUserName(userName);
//        for(EmailDetails dtl : list){
//        emailUtil.sendEmail(dtl);
//         }
//
//        return "Email sent successfully";
//    }

    }









