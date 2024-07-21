package com.rakesh.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.rakesh.capp.domain.User;
import com.rakesh.capp.rm.UserRowMapper;

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
        Map m  =new HashMap();
        m.put("name",u.getName());
		m.put("phone",u.getPhone() );
		m.put("email",u.getEmail());
		m.put("address",u.getAddress());
		m.put("role",u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userId", u.getUserId());
		m.put("pw", u.getPassword());
		
		int res=super.getNamedParameterJdbcTemplate().update(q, m);
		System.out.println(res);
		return res;
	}

	@Override
	public void delete(User u) {
							this.deleteById(u.getUserId());
	}

	@Override
	public void deleteById(Integer userId) {
					String q ="delete from user where userId=?";
					getJdbcTemplate().update(q, userId);
	}

	@Override
	public User findById(Integer userId) {
		String q= "SELECT userid, name,phone,email,address,loginName,role,loginStatus FROM user WHERE userid=?";
		User u = super.getJdbcTemplate().queryForObject(q,new UserRowMapper(),userId);
		return u ;
	}

	@Override
	public List<User> findAll() {
		String query ="Select  userid, name,phone,email,address,loginName,role,loginStatus FROM user ";
		List<User> ulist = getJdbcTemplate().query(query, new UserRowMapper());
		return ulist;
	}

	@Override
	public List<User> findByProperty(String prop, Object propValue) {
		String query ="Select  userid, name,phone,email,address,loginName,role,loginStatus FROM user where" +prop+"=?";
		List<User> users = super.getJdbcTemplate().query(query, new UserRowMapper(),propValue);
		return users;
	}

}
