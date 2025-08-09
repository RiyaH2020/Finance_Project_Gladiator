package com.casestudy.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.dto.UpdateUser;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.DocumentUploadException;
import com.casestudy.exception.UserServiceException;
import com.casestudy.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public int register(RegisteredUser user) {

		if (userRepository.isUserPresent(user.getUsername()))
			throw new UserServiceException("Username already exists...!!");
		else {

			RegisteredUser newUser = (RegisteredUser) userRepository.save(user);
			return newUser.getUserId();
		}
	}

	public RegisteredUser login(String username, String password) {

		try {
			if (!userRepository.isUserPresent(username))
				throw new UserServiceException("User not registered");
			int id = userRepository.findByUsernameAndPassword(username, password);
			RegisteredUser registeredUser = userRepository.fetch(RegisteredUser.class, id);
			return registeredUser;
		} catch (NoResultException e) {
			throw new UserServiceException("Incorrect password");
		}
	}

	public void updateProfilePic(String username, String newFileName) {
		int id = userRepository.findByUsername(username);
		RegisteredUser user = userRepository.fetch(RegisteredUser.class, id);
		user.setDocument(newFileName);
		userRepository.save(user);
	}

	public void isDocUploaded(String username) {
		try {
			userRepository.isDocUploaded(username);
		} catch (NullPointerException e) {
			throw new DocumentUploadException("Upload the required documents");
		}

	}
	
	public RegisteredUser getUserByUsername(String username) {
		int userId = userRepository.findByUsername(username);
		return userRepository.fetch(RegisteredUser.class, userId);
	}

	public String updateUser(UpdateUser user) {
		int userId = userRepository.findByUsername(user.getOldUserName());

		if (!user.getOldUserName().equals(user.getNewUserName()) && userRepository.isUserPresent(user.getNewUserName()))
		throw new UserServiceException("UserId already taken");
		
		RegisteredUser userToUpdate = userRepository.fetch(RegisteredUser.class, userId);
		userToUpdate.setUsername(user.getNewUserName());
		userToUpdate.setName(user.getName());
		userToUpdate.setPhoneNumber(user.getPhoneNumber());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setAddress(user.getAddress());
		userToUpdate.setBankName(user.getBankName());
		userToUpdate.setAccountNumber(user.getAccountNumber());
		userToUpdate.setIfsc(user.getIfsc());
		userToUpdate.setPassword(user.getPassword());
		RegisteredUser updatedUser = (RegisteredUser)userRepository.save(userToUpdate);
		return updatedUser.getUsername();
	}
}
