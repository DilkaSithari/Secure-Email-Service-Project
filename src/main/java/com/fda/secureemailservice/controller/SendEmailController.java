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
    public String sendEmail(@PathVariable("userName") String userName) {
          emailService.sendEmail(userName);
        return "Email Sent";
    }

}
