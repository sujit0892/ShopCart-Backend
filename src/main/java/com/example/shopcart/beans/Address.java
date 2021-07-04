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
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private boolean isDefault;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

	public Address(String address, boolean isDefault, User user) {
		super();
		this.address = address;
		this.isDefault = isDefault;
		this.user = user;
	}
	
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
