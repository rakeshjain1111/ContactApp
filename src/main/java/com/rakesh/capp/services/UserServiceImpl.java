package com.rakesh.capp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.capp.dao.BaseDAO;
import com.rakesh.capp.dao.UserDao;
import com.rakesh.capp.domain.User;
import com.rakesh.capp.exception.UserBlockedException;
import com.rakesh.capp.rm.UserRowMapper;
@Service
public class UserServiceImpl extends BaseDAO implements UserService {
    
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void register(User u) {
		userDao.save(u);
	}

	@Override
	public User login(String loginName, String password) {
         String query ="SELECT userid, name, phone, email, address, role, loginStatus, loginName"+"From user WHERE loginName =:In AND password=:pw";
         Map  m =new HashMap();
         m.put("In",loginName);
		 m.put("pw", password);
		 try {
		   User u=	getNamedParameterJdbcTemplate().queryForObject(query, m, new UserRowMapper());
			if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your Account has been blocked, Contact to admin");
			}
			else {
				return u;
			}
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<User> getAllUser(String prop, Object propValue) {
		return userDao.findByProperty(prop, propValue);
	}

	@Override
	public int updateUser(User u) {
		return userDao.update(u);
	}

	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteById(userId);
	}

	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUserAvailable(String loginName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmailAvailable(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPass(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
