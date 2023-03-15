package com.fda.secureemailservice.controller;
import com.fda.secureemailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email/")
public class SendEmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/sendEmail/{userName}")
    public ResponseEntity<Object> sendEmail(@PathVariable("userName") String userName) {
         ResponseEntity<Object> sendEmail = emailService.sendEmail(userName);
        return sendEmail;
    }

}
