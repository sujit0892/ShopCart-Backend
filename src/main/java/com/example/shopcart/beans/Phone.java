package com.example.shopcart.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phone_id;
	
	@Column(nullable=false,length=20)
	private String phone;
	
	@Column(nullable=false)
	private boolean isDefault;
	
	@ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

	public Phone(String phone, boolean isDefault, User user) {
		super();
		
		this.phone = phone;
		this.isDefault = isDefault;
		this.user = user;
	}
	
	

	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
