package com.rakesh.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.rakesh.capp.domain.User;

public class UserDaoImpl extends BaseDAO implements UserDao {

	@Override
	public void save(User u) {
				String q = "Insert into user(name,phone,email,address,loginName,password,role,loginStatus)"
								+"values(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
				Map m = new HashMap();
				m.put("name",u.getName());
				m.put("phone",u.getPhone() );
				m.put("email",u.getEmail());
				m.put("address",u.getAddress());
				m.put("loginName",u.getLoginName());
				m.put("password",u.getPassword());
				m.put("role",u.getRole());
				m.put("loginStatus", u.getLoginStatus());
				
				KeyHolder kh = new GeneratedKeyHolder();
				SqlParameterSource ps= new MapSqlParameterSource(m);
				super.getNamedParameterJdbcTemplate().update(q,ps,kh);
				Integer userId = kh.getKey().intValue();
				u.setUserId(userId);
				
	}

	@Override
	public int update(User u) {
        String q= "update user set "+"name=:name,"+"phone=:phone," + "email=:email,"+"address=:address,"+"role=:role," 
        				+"loginStatus=:loginStatus"+"where userId=:userId And password=:pw";
		return 0;
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByProperty(String prop, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
