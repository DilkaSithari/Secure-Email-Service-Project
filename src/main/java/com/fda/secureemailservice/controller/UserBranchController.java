package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.model.SecureEmailResponse;
import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.service.UserBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/userBranch")
public class UserBranchController {
    @Autowired
    UserBranchService userBranchService;
    SecureEmailResponse secureEmailResponse = new SecureEmailResponse();
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        Map<String, Object> map = new LinkedHashMap<>();
        try{

        List<UserBranch> userBranchList = userBranchService.findAll();
        if (!userBranchList.isEmpty()) {
            map.put("status", 1);
            map.put("data", userBranchList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } }
        catch (Exception e){
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return null;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUserBranch(@RequestBody UserBranch userBranch) {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            userBranchService.addUserBranch(userBranch);
            map.put("status", 1);
            map.put("message", "User branch added Successfully!");
            return new ResponseEntity<>(map, HttpStatus.CREATED);

        }
        catch (DuplicateKeyException e){
            map.clear();
            map.put("status", 1);
            map.put("message", "User name already exist");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        catch (DataIntegrityViolationException e){
            map.clear();
            map.put("status", 1);
            map.put("message", "branch code not exist");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
          return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@GetMapping("/{userName}")
public ResponseEntity<?> findByUserName(@PathVariable ("userName") String userName) {
    Map<String, Object> map = new LinkedHashMap<>();
    try {
        List<UserBranch> userBranch = userBranchService.findByUserName(userName);
        map.put("status", 1);
        map.put("data", userBranch);
        return new ResponseEntity<>(map, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
//        map.clear();
//        map.put("status", 0);
//        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}


//    @GetMapping("/{userName}")
//    public List<UserBranch> findByUserName(@PathVariable ("userName") String userName){
//        return userBranchService.findByUserName(userName);
//    }

    @PutMapping("/update/{userName}")
    public ResponseEntity<?> updateUserBranch(@RequestBody UserBranch userBranch, @PathVariable ("userName") String userName) {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            map.put("status", 1);
            map.put("message", "User Branch updated successfully");
            map.put("data", userBranchService.updateUserBranch(userName,userBranch));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 1);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
//    public int updateUserBranch(@RequestBody UserBranch userBranch, @PathVariable ("userName") String userName){
//         return  userBranchService.updateUserBranch(userName,userBranch);
//    }


    @GetMapping("/delete/{userName}")
    public ResponseEntity<?> deleteUserBranch(@PathVariable ("userName") String userName) {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            List<UserBranch> userBranch = userBranchService.findByUserName(userName);
            userBranchService.deleteUserBranch(userName);
            map.put("status", 1);
            map.put("message", "User Branch deleted successfully!");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
//    public int deleteUserBranch(@PathVariable ("userName") String userName){
//        return userBranchService.deleteUserBranch(userName);
//
//    }


}
