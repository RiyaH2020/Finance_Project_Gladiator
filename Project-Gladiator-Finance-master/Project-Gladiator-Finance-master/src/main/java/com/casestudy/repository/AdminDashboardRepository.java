package com.casestudy.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.casestudy.dto.ChangeStatus;
import com.casestudy.dto.DashboardCardType;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.Card;
import com.casestudy.entity.RegisteredUser;

@Repository
public class AdminDashboardRepository extends GenericRepository{

	public List<RegisteredUser> fetchAllUsers(int adminId)
	{
		List<RegisteredUser> userlist = entityManager.createQuery("select user from RegisteredUser user join user.admin ad where ad.adminId = :adminId order by user.status desc").setParameter("adminId", adminId).getResultList();
		return userlist;
	}
	
	 
	@Transactional
	public ChangeStatus changeStatus(int userId, String status)
	{
		RegisteredUser user = entityManager.find(RegisteredUser.class, userId);
		ChangeStatus statuschange = new ChangeStatus();
		if(user.getStatus().equalsIgnoreCase("Approved"))
		{
		statuschange.setUserId(userId);
		statuschange.setStatus(StatusType.FAILED);
		statuschange.setMessage("User already approved");
		}
		else
		{
		user.setStatus(status);
		statuschange.setUserId(userId);
		statuschange.setStatus(StatusType.SUCCESS);
		statuschange.setMessage("status changes successfully");
		}
		save(user);	
		return statuschange;
	}
	
	public List<RegisteredUser> fetchUsersByStatus(int adminId,String status)
	{
		List<RegisteredUser> userlist = entityManager.createQuery("select user from RegisteredUser user join user.admin ad where ad.adminId = :adminId and user.status = :status").setParameter("adminId", adminId).setParameter("status", status).getResultList();
		return userlist;
	}
	
	public DashboardCardType fetchCardType(int userId)
	{
		RegisteredUser user = entityManager.find(RegisteredUser.class, userId);
		DashboardCardType type = new DashboardCardType();
		type.setCardType(user.getCardType());
		type.setStatus(StatusType.SUCCESS);
		type.setMessage("success");
		return type;
	}
	
	public Long FetchPendingCount(int adminId) { 
		
		return (Long)entityManager.createQuery("select count(user) from RegisteredUser user join user.admin ad where ad.adminId = :adminId and user.status <> :status").setParameter("adminId", adminId).setParameter("status","Approved").getSingleResult();
		
	}
	

	public Card fetchCardByuserId(int userId) {
		Query q=entityManager.createQuery("select c from Card c join c.registeredUser r where r.userId=:id");
		q.setParameter("id", userId);
		Card c=(Card)q.getSingleResult();
		return c;
		
	}
	}


