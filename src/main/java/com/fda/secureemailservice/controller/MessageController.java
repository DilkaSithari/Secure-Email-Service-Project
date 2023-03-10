package com.fda.secureemailservice.controller;
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
    MessageService messageService;

    @GetMapping("/usernames")
    public List<String> getAllUserNames(){
        return messageService.getAllUserNames();
    }
    @GetMapping("/getDetails/{userName}")
    public ResponseEntity<Object> getDetailsByUserName(@PathVariable String userName) {
        ResponseEntity<Object> getDetailsByUserName= messageService.getDetailsByUserName(userName);
        return getDetailsByUserName;
    }




    EmailUtil emailUtil = new EmailUtil();
//    @RequestMapping(value = "/sendemail")
//    public String sendEmail()    {
//        emailUtil.sendEmail();
//        return "Email sent successfully";
//    }
//branch email   -> getEmailByUserName
    //subject
    //msg

    //


}
