package com.sapient.assessment3.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.assessment3.model.User;

@Transactional
@Repository("hibernateDAOImp")
public class userDAOImp implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
	public void saveUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		session.saveOrUpdate(user);
		
	}

	public List<User> listAll() {
		// TODO Auto-generated method stub
				Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

}
