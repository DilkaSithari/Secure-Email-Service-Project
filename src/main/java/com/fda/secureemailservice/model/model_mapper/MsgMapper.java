package com.fda.secureemailservice.model.model_mapper;
import com.fda.secureemailservice.model.Msg;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MsgMapper  implements RowMapper<Msg>{

        public Msg mapRow(ResultSet rs, int rowNum) throws SQLException {
            Msg msg = new Msg();
            msg.setId(rs.getInt("id"));
            msg.setSubject(rs.getString("subject"));
            msg.setMessage(rs.getString("message"));
            msg.setUserName(rs.getString("user_name"));
            msg.setStatus(rs.getInt("status"));
            msg.setTime(rs.getString("time"));
            return msg;
        }
}
