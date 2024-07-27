package com.rakesh.capp.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rakesh.capp.config.JdbcConfig;
import com.rakesh.capp.domain.User;
import com.rakesh.capp.services.UserService;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

public class Test {
  public static void main(String[] args) {
	  ApplicationContext ctx =new AnnotationConfigApplicationContext(JdbcConfig.class);
	//JdbcTemplate template= ctx.getBean("jdbcTemplate",JdbcTemplate.class);
	UserService userService=ctx.getBean(UserService.class);
	User u = new User();
	u.setName("Ram");
	u.setPhone("555555");
	u.setEmail("r@gmail.com");
	u.setAddress("sagar");
	u.setLoginName("rkjain");
	u.setPassword("11111111");
	u.setRole(UserService.ROLE_ADMIN);
	u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
	userService.register(u);
	System.out.println("-----User------");
//	  
//	  String q ="insert into user(name,phone,email,address,loginName,password) values(?,?,?,?,?,?)";
//	  Object [] param = new Object[] {"rakesh","1111","rk@g.c","sagar","rk","12345"};
//	  template.update(q,param);
}
}
