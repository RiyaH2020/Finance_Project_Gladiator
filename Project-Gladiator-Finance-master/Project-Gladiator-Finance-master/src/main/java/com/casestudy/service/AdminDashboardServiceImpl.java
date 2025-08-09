package com.casestudy.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.dto.ChangeStatus;
import com.casestudy.dto.DashboardCardType;
import com.casestudy.entity.Admin;
import com.casestudy.entity.Card;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.AdminDashboardException;
import com.casestudy.repository.AdminDashboardRepository;

@Service
@Transactional
public class AdminDashboardServiceImpl implements AdminDashboardService {

	@Autowired
	private AdminDashboardRepository dao;

	public List<RegisteredUser> getAllUsers(int adminId) {
		try {
			List<RegisteredUser> userlist = dao.fetchAllUsers(adminId);
			if (userlist.size() == 0) {
				throw new AdminDashboardException("No user under admin with id " + adminId);
			}
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RegisteredUser> fetchUsersByStatus(int adminId, String status) {
		try {
			Admin ad = new Admin();
			ad = dao.fetch(Admin.class, adminId);

			if (ad == null)
				throw new AdminDashboardException("No admin with id " + adminId);

			List<RegisteredUser> userlist = dao.fetchUsersByStatus(adminId, status);

			if (userlist.size() == 0) {
				throw new AdminDashboardException("No user with status " + status + " under admin with id " + adminId);
			}

			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ChangeStatus changeStatus(int userId, String status, String cardType) {
		
		RegisteredUser user=dao.fetch(RegisteredUser.class, userId);
		if(user.getStatus().equals("Renewal")) {
			ChangeStatus stat = dao.changeStatus(userId, status);
			Card card=dao.fetchCardByuserId(userId);
			card.setExpiry_date(LocalDate.now().plusYears(1));
			if(card.getCardType().equals("Gold")) {
				card.setAmountGranted(25000);
				card.setAmountRemaining(25000);
			}
			else if(card.getCardType().equals("Platinum")) {
				card.setAmountGranted(50000);
				card.setAmountRemaining(50000);	
			}
			dao.save(card);
			return stat;
		}

		else {
			ChangeStatus stat = dao.changeStatus(userId, status);
			if (cardType.equals("Gold")) {
				
				Card card = new Card();

				card.setAmountGranted(25000);
				card.setAmountRemaining(25000);
				card.setCardType("gold");
				card.setStartDate(LocalDate.now());
				card.setExpiry_date(LocalDate.now().plusYears(1));

				card.setRegisteredUser(dao.fetch(RegisteredUser.class, userId));

				dao.save(card);
			}

			else if (cardType.equals("Platinum")) {
				Card card = new Card();

				card.setAmountGranted(50000);
				card.setAmountRemaining(50000);
				card.setCardType("Platinum");
				card.setStartDate(LocalDate.now());
				card.setExpiry_date(LocalDate.now().plusYears(1));

				card.setRegisteredUser(dao.fetch(RegisteredUser.class, userId));

				dao.save(card);

			}
			return stat;
		}
	}
	
	public DashboardCardType getCardType(int userId)
	{
		return dao.fetchCardType(userId);
	}

	public long FetchPendingCount(int adminId) {
		
		return dao.FetchPendingCount(adminId);
	}

	

}