package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.ChangeStatus;
import com.casestudy.dto.DashboardCardType;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.service.AdminDashboardService;

@RestController
@CrossOrigin
public class AdminDashboardController {

	@Autowired
	private AdminDashboardService service;
	
	@GetMapping(path = "/getAllUser")
	public @ResponseBody List<RegisteredUser> getUser(@RequestParam("adminId") int adminId)
	{
		return service.getAllUsers(adminId);
	}
	
	
	@GetMapping(path = "/getuserbystatus")
	public @ResponseBody List<RegisteredUser> getApprovedUser(@RequestParam("adminId") int adminId,@RequestParam("status") String status)
	{
		return service.fetchUsersByStatus(adminId, status);
	}
	
	
	@GetMapping(path = "/changestatus")
	public @ResponseBody ChangeStatus changeStatus(@RequestParam("userId") int userId,@RequestParam("status") String status,@RequestParam("cardType")String cardType)
	{
		return service.changeStatus(userId, status, cardType);
		
	}
	

	@GetMapping(path = "/getcardtype")
	public @ResponseBody DashboardCardType getCardType(@RequestParam("userId") int userId)
	{
		return service.getCardType(userId);
		
	}
	
	@GetMapping(path="/fetchpendingcount")
	public @ResponseBody long FetchPendingCount(@RequestParam("adminId")int adminId) {
		
		return (Long)service.FetchPendingCount(adminId);
		
		
	}
	
	
}
