package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.repository.impl.MessageRepositoryImpl;
import com.fda.secureemailservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/service")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/usernames")
    public List<String> getAllUserNames(){
        return messageService.getAllUserNames();
    }
    @GetMapping("/getEmail/{userName}")
    public String  getEmailByUserName(@PathVariable String userName) {
        String getEmailByUserName= messageService.getEmailByUserName(userName);
        return getEmailByUserName;
    }
//    public ResponseEntity<?>  getEmailByUserName(@PathVariable String userName) {
//        Map<String, Object> map = new LinkedHashMap<>();
//        try{
//        String email = messageService.getEmailByUserName(userName);
//        if (!email.isEmpty()){
//            map.put("status", 1);
//            map.put("data", email);
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        } }
//
//        catch (EmptyResultDataAccessException e){
//            map.clear();
//            map.put("status", 0);
//            map.put("message", "User name not exist");
//            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//        return null;
//    }
//    public String getEmailByUserName(@PathVariable String userName){
//        return messageService.getEmailByUserName(userName);
//    }


}
