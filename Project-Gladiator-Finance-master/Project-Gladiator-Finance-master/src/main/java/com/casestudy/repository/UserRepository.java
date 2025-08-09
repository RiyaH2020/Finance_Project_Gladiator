package com.casestudy.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends GenericRepository {

	public boolean isUserPresent(String username) {

		return (Long) entityManager.createQuery("select count(u.id) from RegisteredUser u where u.username= :username")
				.setParameter("username", username).getSingleResult() == 1 ? true : false;

	}

	public int findByUsernameAndPassword(String username, String password) {
		return (Integer) entityManager
				.createQuery(
						"select u.id from RegisteredUser as u where u.username = :username and u.password = :password")
				.setParameter("username", username).setParameter("password", password).getSingleResult();
	}

	
	public boolean isAdminPresent(String username) {

		return (Long) entityManager.createQuery("select count(a.id) from Admin a where a.username= :username")
				.setParameter("username", username).getSingleResult() == 1 ? true : false;

	}

	
	public int findByAdminnameAndPassword(String username, String password) {
		return (Integer) entityManager
				.createQuery(
						"select a.id from Admin as a where a.username = :username and a.password = :password")
				.setParameter("username", username).setParameter("password", password).getSingleResult();
	}
	
	public int findByUsername(String username) {
		return (Integer) entityManager
				.createQuery(
						"select u.id from RegisteredUser as u where u.username = :username")
				.setParameter("username", username).getSingleResult();
	}
	
	
	public boolean isDocUploaded(String username) {
		Query q=entityManager.createQuery("select r.document from RegisteredUser r where r.username=:username");
		q.setParameter("username", username);
		if(q.getSingleResult().equals(null))
			return false;
		else
			return true;
	}

}
