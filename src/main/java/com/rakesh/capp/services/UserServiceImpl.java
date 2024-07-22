package com.rakesh.capp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.capp.dao.BaseDAO;
import com.rakesh.capp.dao.UserDao;
import com.rakesh.capp.domain.User;
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
		// TODO Auto-generated method stub
		return null;
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
