package com.example.shopcart.JSONEntity;

public class CartJSON {
	
	
	private int quantity;
	private String product_id;
	private String user_id;
	private String cat_id;
	
	public CartJSON() {
		// TODO Auto-generated constructor stub
	}
	
	public CartJSON(int quantity, String product_id, String user_id, String cat_id) {
		super();
		this.quantity = quantity;
		this.product_id = product_id;
		this.user_id = user_id;
		this.cat_id = cat_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	

}
