package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.Login;
import com.casestudy.dto.LoginStatus;
import com.casestudy.dto.LoginStatus.DocUploadStatus;
import com.casestudy.dto.Status;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.DocumentUploadException;
import com.casestudy.exception.UserServiceException;
import com.casestudy.service.UserService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			RegisteredUser user = userService.login(login.getName(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Login Success");
			status.setUserId(user.getUserId());
			status.setName(user.getUsername());
			userService.isDocUploaded(user.getUsername());
			status.setDocStatus(DocUploadStatus.UPLOADED);
			
			return status;
		} catch (UserServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			status.setDocStatus(DocUploadStatus.NOT_UPLOADED);
			return status;
		}
		catch(DocumentUploadException e) {
			RegisteredUser user = userService.login(login.getName(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setUserId(user.getUserId());
			status.setName(user.getUsername());
			status.setMessage(e.getMessage());
			status.setDocStatus(DocUploadStatus.NOT_UPLOADED);
			return status;
		}
	}
}
