package com.example.shopcart.JSONEntity;

public class PhoneJSON {
	private String user_id;
	private String phone;
	private boolean isDefault;
	private int id;
	
	
	
	public PhoneJSON(String user_id, String phone, boolean isDefault, int id) {
		super();
		this.user_id = user_id;
		this.phone = phone;
		this.isDefault = isDefault;
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
	
}
