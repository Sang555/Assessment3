package com.sapient.assessment3.Dao;

import java.util.List;

import com.sapient.assessment3.model.*;
public interface UserDAO {
	public void saveUser(User user);
	public List<User> listAll();
	public User findById(long id);
	public void update(long id, User user);
	public void deleteuser(long id); 
	public List<Posts> findPostById(long id);

}
