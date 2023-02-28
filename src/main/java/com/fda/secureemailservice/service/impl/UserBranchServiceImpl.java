package com.fda.secureemailservice.service.impl;

import com.fda.secureemailservice.model.UserBranch;
import com.fda.secureemailservice.repository.UserBranchRepo;
import com.fda.secureemailservice.service.UserBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserBranchServiceImpl implements UserBranchService {

    @Autowired
    private UserBranchRepo userBranchRepo;
    @Override
    public List<UserBranch> findAll() {
        return userBranchRepo.findAll();
    }

    @Override
    public List<UserBranch> findByUserName(String userName) {
        return userBranchRepo.findByUserName(userName);
    }

    @Override
    public int updateUserBranch(String userName, UserBranch userBranch) {
        userBranchRepo.updateUserBranch(userName,userBranch);
        return 0;
    }

    @Override
    public void addUserBranch(UserBranch userBranch) {
        userBranchRepo.addUserBranch(userBranch);
    }

    @Override
    public int deleteUserBranch(String userName) {
        return userBranchRepo.deleteUserBranch(userName);
    }
}
