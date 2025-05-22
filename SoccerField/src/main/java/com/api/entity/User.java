package com.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name", unique = true)
	private String userName;
	private String password;
	private String phone;
	private float wallet = 0.0f;
	private int role = 1; // 1: user, 2: admin
	private int status = 1; // 1: active, 0: inactive

	public User() {
	}

	public User(String userName, String password, String phone)
	{
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public float getWallet()
	{
		return wallet;
	}

	public void setWallet(float wallet)
	{
		this.wallet = wallet;
	}

	public int getRole()
	{
		return role;
	}

	public void setRole(int role)
	{
		this.role = role;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}
}
