package com.fda.secureemailservice.controller;
import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.service.UserBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/userBranch")
public class UserBranchController {
    @Autowired
    UserBranchService userBranchService;

    @GetMapping("/all")
    public ResponseEntity<Object> findAll(UserBranch userBranch){
       ResponseEntity<Object> findAll = userBranchService.findAll(userBranch);
       return findAll;
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addUserBranch(@RequestBody UserBranch userBranch){
        ResponseEntity<Object> addUserBranch= userBranchService.addUserBranch(userBranch);
        return addUserBranch;
    }
    @GetMapping("/{userName}")
    public ResponseEntity<Object> findByUserName(@PathVariable ("userName") String userName) {
       ResponseEntity<Object> findByUsername= userBranchService.findByUserName(userName);
       return findByUsername;
    }
    @PutMapping("/update/{userName}")
    public ResponseEntity<Object> updateUserBranch( @PathVariable ("userName") String userName, @RequestBody UserBranch userBranch){
        ResponseEntity<Object> updateUserBranch= userBranchService.updateUserBranch(userName,userBranch);
        return updateUserBranch;
    }
    @DeleteMapping("/delete/{userName}")
    public ResponseEntity<Object> deleteUserBranch(@PathVariable ("userName") String userName){
        return userBranchService.deleteUserBranch(userName);
    }
}
