package com.fda.secureemailservice.model.model_mapper;

import com.fda.secureemailservice.model.BranchDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchDetailMapper implements RowMapper<BranchDetail> {
    public BranchDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        BranchDetail branchDetail = new BranchDetail();
        branchDetail.setBranchCode(rs.getInt("branch_code"));
        branchDetail.setBranchName(rs.getString("branch_name"));
        branchDetail.setBranchEmail(rs.getString("branch_email"));
            return branchDetail;
        }


}

