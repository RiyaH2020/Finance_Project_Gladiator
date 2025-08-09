package com.casestudy.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDetails {
	private String username;
	private MultipartFile profilePic;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getDocument() {
		return profilePic;
	}
	public void setDocument(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
	
}
