package com.rakesh.capp.services;

import java.util.List;

import com.rakesh.capp.modal.User;

public class UserServiceImpl implements UserService {

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String loginName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser(String prop, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

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
