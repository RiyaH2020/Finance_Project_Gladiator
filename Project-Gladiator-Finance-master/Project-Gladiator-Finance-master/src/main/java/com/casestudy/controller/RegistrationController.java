package com.casestudy.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.DocumentDetails;
import com.casestudy.dto.RegisterStatus;
import com.casestudy.dto.Status;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.UserServiceException;
import com.casestudy.service.UserService;

@RestController
@CrossOrigin
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody RegisteredUser user) {
		
		try {
			int id = userService.register(user);
			
			
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful..!!");
			status.setRegisteredCustomerId(id);
			
			return status;
			}catch(UserServiceException e) {
				RegisterStatus status = new RegisterStatus();
				status.setStatus(StatusType.FAILED);
				status.setMessage(e.getMessage());
				return status;
			}
	}
	
	@PostMapping("/upload")
	public Status upload(DocumentDetails docDetails) {
		String uname=docDetails.getUsername();
		String docUploadLocation="E:/Project Gladiator/uploads/";
		String uploadedFileName=docDetails.getDocument().getOriginalFilename();
		String newFileName=uname+"-"+uploadedFileName;
		String targetFileName=docUploadLocation+newFileName;
		try {
			FileCopyUtils.copy(docDetails.getDocument().getInputStream(), new FileOutputStream(targetFileName));
		}
		catch(IOException e) {
			e.printStackTrace();
			Status status=new Status();
			status.setStatus(StatusType.FAILED);
			status.setMessage("File upload failed");
			return status;
		}
		
		userService.updateProfilePic(uname,newFileName);
		Status status=new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Document uploaded");
		return status;
	}

	
	
}
