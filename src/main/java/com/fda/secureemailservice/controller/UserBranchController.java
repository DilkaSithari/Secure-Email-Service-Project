package com.fda.secureemailservice.controller;

import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.service.UserBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userBranch")
public class UserBranchController {
    @Autowired
    UserBranchService userBranchService;

    @PostMapping("/add")
    public void addUserBranch(@RequestBody UserBranch userBranch){
        userBranchService.addUserBranch(userBranch);
    }
    @GetMapping("/all")
    public List<UserBranch> findAll(){
        return userBranchService.findAll();
    }
    @PutMapping("/update/{userName}")
    public int updateUserBranch(@RequestBody UserBranch userBranch, @PathVariable ("userName") String userName){
         return  userBranchService.updateUserBranch(userName,userBranch);
    }

    @GetMapping("/{userName}")
    public List<UserBranch> findByUserName(@PathVariable ("userName") String userName){
        return userBranchService.findByUserName(userName);
    }
    @GetMapping("/delete/{userName}")
    public int deleteUserBranch(@PathVariable ("userName") String userName){
        return userBranchService.deleteUserBranch(userName);

    }

}
