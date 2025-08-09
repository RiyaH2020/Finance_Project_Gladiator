package com.casestudy.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.entity.Admin;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.UserServiceException;
import com.casestudy.repository.UserRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private UserRepository userRepository;
	
	public Admin login(String username, String password) {

		try {
			if(!userRepository.isAdminPresent(username))
				throw new UserServiceException("Admin not registered");
			int id = userRepository.findByAdminnameAndPassword(username, password);
			Admin admin = userRepository.fetch(Admin.class, id);
			return admin;
		}
		catch(NoResultException e) {
			throw new UserServiceException("Incorrect password");
		}
	
	}

}
