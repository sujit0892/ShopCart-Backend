package com.example.shopcart.JSONEntity;

import java.util.List;

public class OrderJSON {
	
	private List<Integer> cart_id;
	private String user_id;
	private int address_id;
	private int phone_id;
	
	
	public OrderJSON() {
		// TODO Auto-generated constructor stub
	}


	public OrderJSON(List<Integer> cart_id, String user_id, int address_id, int phone_id) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.address_id = address_id;
		this.phone_id = phone_id;
	}


	public List<Integer> getCart_id() {
		return cart_id;
	}


	public void setCart_id(List<Integer> cart_id) {
		this.cart_id = cart_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public int getAddress_id() {
		return address_id;
	}


	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	public int getPhone_id() {
		return phone_id;
	}


	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	
	
	

}
