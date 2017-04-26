package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserDao;
import com.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping("/getUserByName")
	public String getUserByName(HttpServletRequest request,String name){
		List<User> userlist=userDao.getUsersByName("%"+name+"%");
		request.setAttribute("userlist", userlist);
		return "getAll";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		request.setAttribute("userlist", userDao.getAllUser());
		return "getAll";
	}
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,String name,String tel){
		User user=new User();
		user.setName(name);
		user.setTel(tel);
		userDao.insertUser(user);
		return getAllUser(request);
	}
	
	@RequestMapping("/delete")
	public String deleteUserById(HttpServletRequest request,int id){
		userDao.deleteUserById(id);
		return getAllUser(request);
	}
	
	@RequestMapping("/update")
	public String updateUser(HttpServletRequest request,String name,String tel,int id){
		User user=userDao.getUserById(id);
		user.setName(name);
		user.setTel(tel);
		userDao.updateUserById(user);
		return getAllUser(request);
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,int id){
		User user=userDao.getUserById(id);
		request.setAttribute("user", user);
		return "edit";
	}
}