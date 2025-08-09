package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.AdminLoginStatus;
import com.casestudy.dto.Login;
import com.casestudy.dto.LoginStatus;
import com.casestudy.dto.Status;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.Admin;
import com.casestudy.exception.UserServiceException;
import com.casestudy.service.AdminLoginService;

@RestController
@CrossOrigin
public class AdminLoginController {

	@Autowired 
	private AdminLoginService adminLoginService;
	
	@PostMapping("/adminlogin")
	public AdminLoginStatus login(@RequestBody Login login) {
		try {
			Admin admin = adminLoginService.login(login.getName(), login.getPassword());
			AdminLoginStatus status = new AdminLoginStatus();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Login Success");
			status.setAdminId(admin.getAdminId());
			status.setName(admin.getUsername());
			return status;
		} catch (UserServiceException e) {
			AdminLoginStatus status = new AdminLoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
