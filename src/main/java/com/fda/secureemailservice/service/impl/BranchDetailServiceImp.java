package com.fda.secureemailservice.service.impl;

import com.fda.secureemailservice.model.BranchDetail;
import com.fda.secureemailservice.repository.BranchDetailRepo;
import com.fda.secureemailservice.service.BranchDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchDetailServiceImp  implements BranchDetailService {
    @Autowired
    private BranchDetailRepo branchDetailRepo;

    @Override
    public List<BranchDetail> findAll() {
        return branchDetailRepo.findAll();
    }

    @Override
    public List<BranchDetail> findByBranchCode(int branchCode) {
        return branchDetailRepo.findByBranchCode(branchCode);
    }

    @Override
    public void updateBranchDetail(int branchCode, BranchDetail branchDetail) {
       branchDetailRepo.updateBranchDetail(branchCode,branchDetail);
    }

    @Override
    public void addBranchDetail(BranchDetail branchDetail) {
        branchDetailRepo.addBranchDetail(branchDetail);
    }


    @Override
    public int deleteBranchDetail(int branchCode) {
        return branchDetailRepo.deleteBranchDetail(branchCode);
    }
}
