package com.myshop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.myshop.domain.User;
import com.myshop.vo.UserForm;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertUser(User user) {
		em.persist(user);
	}
	
	public User findUserid(UserForm userForm) {
		List<User> userList = em.createQuery("select u From User u where u.userid = :userid", User.class)
				.setParameter("userid", userForm.getUserid())
				.getResultList();
		
		if(userList == null) {
			User user = null;
			return user;
		}else {
			User user = userList.get(0);
			
			if(user.getUserpw().equals(userForm.getUserpw())) {
				return user;
			}else {
				return null;
			}
		}
	}
	
	public User findUser(long id) {
		User user = em.find(User.class, id);
		return user;
	}
}
