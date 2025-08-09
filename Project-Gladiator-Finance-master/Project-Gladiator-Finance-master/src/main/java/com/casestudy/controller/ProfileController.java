package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.Status.StatusType;
import com.casestudy.dto.UpdateUser;
import com.casestudy.dto.UpdateUserStatus;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.UserServiceException;
import com.casestudy.service.UserService;

@RestController
@CrossOrigin
public class ProfileController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/update-profile")
	public UpdateUserStatus updateProfile(@RequestBody UpdateUser user) {
		try {
			String updatedUsername = userService.updateUser(user);
			UpdateUserStatus status = new UpdateUserStatus();
			status.setUsername(updatedUsername);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Details updated successfully");
			return status;
		}
		catch(UserServiceException e){
			UpdateUserStatus status = new UpdateUserStatus();
			status.setUsername(user.getOldUserName());
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping("/get-profile")
	public RegisteredUser getUser(@RequestParam("uname") String username) {
		return userService.getUserByUsername(username);
	}
}
