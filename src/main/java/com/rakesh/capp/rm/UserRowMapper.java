package com.rakesh.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rakesh.capp.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u =new User();
		u.setUserId(rs.getInt(rs.getInt("userId")));
		u.setName(rs.getString("name"));
		u.setPhone(rs.getString(rs.getString("phone")));
		u.setAddress(rs.getString("address"));
		u.setEmail(rs.getString("email"));
		u.setLoginName(rs.getString("loginName"));
		u.setRole(rs.getInt("role"));
		u.setLoginStatus(rs.getInt("loginStatus"));
		return u;
	}

}
