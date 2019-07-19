package com.sapient.assessment3.Dao;

import java.util.List;

import com.sapient.assessment3.model.User;

public interface UserDAO {
	public void saveUser(User user);
	public List<User> listAll();
	public User findById(int id);

}
