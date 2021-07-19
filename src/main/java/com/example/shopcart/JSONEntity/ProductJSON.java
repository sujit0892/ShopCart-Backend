package com.example.shopcart.JSONEntity;

import java.util.List;

import com.example.shopcart.beans.Category;

public class ProductJSON {

	
	private String product_id;
	private String name;
	

	
	
	private int cat_id;
	
	
	
	
	private String brand_name;
	
	
	private int discount;
	
	
	private int price;
	
	
	private boolean shipping;
	
	
	private String description;
	
	
	private String feature;
	
	
	private int stock;
	
	
	private int minOrder;
	
	
	private int maxOrder;
	
	private String user_id;
	
	private List<String> images;
	
	public ProductJSON() {
		// TODO Auto-generated constructor stub
	}

	

	



	public ProductJSON(String name, int cat_id, String brand_name, int discount, int price, boolean shipping,
			String description, String feature, int stock, int minOrder, int maxOrder, String user_id,
			List<String> images) {
		super();
		this.name = name;
		this.cat_id = cat_id;
		this.brand_name = brand_name;
		this.discount = discount;
		this.price = price;
		this.shipping = shipping;
		this.description = description;
		this.feature = feature;
		this.stock = stock;
		this.minOrder = minOrder;
		this.maxOrder = maxOrder;
		this.user_id = user_id;
		this.images = images;
	}







	public List<String> getImages() {
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(int minOrder) {
		this.minOrder = minOrder;
	}

	public int getMaxOrder() {
		return maxOrder;
	}

	public void setMaxOrder(int maxOrder) {
		this.maxOrder = maxOrder;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	


}
