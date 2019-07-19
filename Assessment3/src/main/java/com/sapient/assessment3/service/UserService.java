package com.sapient.assessment3.service;
import com.sapient.assessment3.model.*;
import java.util.*;
public interface UserService {
	public void saveUser(User user);
	public List<User> listAll();
	public User findById(long id);
	public void update(long id, User user);
	public void deleteuser(long id); 
	public User findPostById(long id);

}
