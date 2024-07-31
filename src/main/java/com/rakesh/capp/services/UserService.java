package com.rakesh.capp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rakesh.capp.domain.User;
import com.rakesh.capp.exception.UserBlockedException;
@Service
public interface UserService {
		public static final Integer LOGIN_STATUS_ACTIVE = 1;
		public static final Integer LOGIN_STATUS_BLOCKED = 2;
		
		public static final Integer ROLE_ADMIN =1;
		public static final Integer ROLE_USER =2;
		
		public void register(User u);
		
		public User login(String loginName, String password) throws UserBlockedException;
		
		public List<User> getAllUser(String prop, Object propValue);
		
		public int updateUser(User u);
		
		public void deleteUser(Integer userId);
		
		public User getUser(Integer userId);
		
		public List<User> getUserList();
		
		public void changeLoginStatus(Integer userId, Integer loginStatus);
		
		public boolean isUserAvailable(String loginName);
		
		public boolean isEmailAvailable(String email);
		
		public boolean resetPass(String email, String password);
}
