package com.fda.secureemailservice.model.model_mapper;
import com.fda.secureemailservice.model.UserBranch;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBranchMapper implements RowMapper<UserBranch> {

        public UserBranch mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserBranch userBranch = new UserBranch();
            userBranch.setUserName(rs.getString("user_name"));
            userBranch.setBranchCode(rs.getInt("branch_code"));
            return userBranch;
        }


    }

