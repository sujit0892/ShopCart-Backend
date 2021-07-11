package com.example.shopcart.JSONEntity;

public class AddressJSON {
	private String user_id;
	private String Address;
	private boolean isDefault;
	private int id;
	
	
	
	public AddressJSON(String user_id, String address, boolean isDefault, int id) {
		super();
		this.user_id = user_id;
		Address = address;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	
}
