package com.casestudy.service;

import com.casestudy.entity.Admin;

public interface AdminLoginService {

	public Admin login(String name, String password);
}
