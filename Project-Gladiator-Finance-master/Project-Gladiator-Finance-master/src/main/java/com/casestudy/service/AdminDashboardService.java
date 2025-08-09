package com.casestudy.service;

import java.util.List;

import com.casestudy.dto.ChangeStatus;
import com.casestudy.dto.DashboardCardType;
import com.casestudy.entity.RegisteredUser;

public interface AdminDashboardService {

	public List<RegisteredUser>getAllUsers(int adminId);
	
	public List<RegisteredUser>fetchUsersByStatus(int adminId,String status);
	
	public ChangeStatus changeStatus(int userId, String status, String cardType);
	
	public DashboardCardType getCardType(int userId);
	
	public long FetchPendingCount(int adminId);
}
