package com.fda.secureemailservice.repository.impl;

import com.fda.secureemailservice.model.BranchDetail;
import com.fda.secureemailservice.model.model_mapper.BranchDetailMapper;
import com.fda.secureemailservice.repository.BranchDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchDetailRepoImpl implements BranchDetailRepo {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BranchDetailRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BranchDetail> findAll() {
        String sql="SELECT * FROM tbl_branch_detail;";

        return jdbcTemplate.query(sql,new BranchDetailMapper()) ;
    }

    @Override
    public int addBranchDetail(BranchDetail branchDetail) {
        String sql = " INSERT into tbl_branch_detail(branch_code,branch_name,branch_email) VALUES (?,?,?); ";
        return jdbcTemplate.update(sql,
                branchDetail.getBranchCode(),
                branchDetail.getBranchName(),
                branchDetail.getBranchEmail());
    }

    @Override
    public List<BranchDetail> findByBranchCode(int branchCode) {
        String sql="SELECT * FROM tbl_branch_detail where branch_code=?;";
        return jdbcTemplate.query(sql,new BranchDetailMapper(),branchCode) ;
    }

    @Override
    public int deleteBranchDetail(int branchCode) {
        String sql = "delete from tbl_branch_detail where  branch_code = ?;";
        return jdbcTemplate.update(sql,branchCode);
    }

    @Override
    public int updateBranchDetail(int branchCode, BranchDetail branchDetail) {
        String sql="Update tbl_branch_detail set branch_code=?, branch_name=?,branch_email=? where branch_code=?;";
        return jdbcTemplate.update(sql,
                branchDetail.getBranchCode(),
                branchDetail.getBranchName(),
                branchDetail.getBranchEmail(),branchCode) ;
    }

}
