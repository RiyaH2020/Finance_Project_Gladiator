package com.casestudy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "admin_id")
	private int adminId;
	
	private String username;		 
	private String password;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "phone_no")
	private long phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy="admin",cascade= {CascadeType.MERGE})
	private List<RegisteredUser> users;
	
	@JsonIgnore
	@OneToMany(mappedBy="admin",cascade= {CascadeType.MERGE})
	private List<Product> products;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<RegisteredUser> getUsers() {
		return users;
	}

	public void setUsers(List<RegisteredUser> users) {
		this.users = users;
	}

}
