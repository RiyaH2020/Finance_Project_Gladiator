package com.casestudy.service;

import com.casestudy.dto.UpdateUser;
import com.casestudy.entity.RegisteredUser;

public interface UserService {

	public int register(RegisteredUser user);
	public RegisteredUser login(String name, String password);
	public void updateProfilePic(String username,String newFileName);
	public void isDocUploaded(String username);
	public String updateUser(UpdateUser user);
	public RegisteredUser getUserByUsername(String username);
}
