package com.fda.secureemailservice.service;

import com.fda.secureemailservice.model.BranchDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface BranchDetailService {
    List<BranchDetail> findAll();
    List<BranchDetail> findByBranchCode(int branchCode);
    void updateBranchDetail(int branchCode,BranchDetail branchDetail);

    void addBranchDetail(BranchDetail branchDetail);
    int deleteBranchDetail(int  branchCode);
}
