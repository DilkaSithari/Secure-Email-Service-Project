package com.fda.secureemailservice.repository;

import com.fda.secureemailservice.model.BranchDetail;

import java.util.List;

public interface BranchDetailRepo {
    List<BranchDetail> findAll();
    int addBranchDetail(BranchDetail branchDetail);
    List<BranchDetail> findByBranchCode(int branchCode);
    int deleteBranchDetail(int branchCode);
    int updateBranchDetail(int branchCode, BranchDetail branchDetail);


}
