package com.sapient.assessment3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.assessment3.Dao.UserDAO;
import com.sapient.assessment3.model.*;

import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImp implements UserService{

	
	@Autowired( required = true)
	@Qualifier(value="hibernateDAOImp")
	private UserDAO userDAO;
	
	public UserServiceImp(@Qualifier(value = "hibernateDAOImp")UserDAO userDAO)
	{
		this.userDAO= userDAO;
	}
	
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveUser(user);
		
	}

	@Transactional
	public List<User> listAll() {
		List<User> userList= userDAO.listAll();
		// TODO Auto-generated method stub
		return userList;
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	public void update(long id, User user) {
		// TODO Auto-generated method stub
		userDAO.update(id,user);
		
	}

	public void deleteuser(long id) {
		// TODO Auto-generated method stub
		userDAO.deleteuser(id);
	}

	public List<Posts> findPostById(long id) {
		// TODO Auto-generated method stub
		return userDAO.findPostById(id);
	}

	public Posts findPostByIdById(long id, long pid) {
		// TODO Auto-generated method stub
		return userDAO.findPostByIdById(id,pid);
	}

	public void putPostById(long id, Posts posts) {
		// TODO Auto-generated method stub
		userDAO.putPostById(id,posts);
		
	}

}
