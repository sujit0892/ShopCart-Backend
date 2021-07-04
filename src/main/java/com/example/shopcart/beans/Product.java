package com.example.shopcart.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(nullable=false,length=64)
	private String asin;
	
	@Column(nullable=false)
	private String name;
	

	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category")
	private Category cat_level1;
	
	
	
	@Column
	private String brand_name;
	
	@Column(nullable=false)
	private int discount;
	
	@Column(nullable=false)
	private int price;
	
	@Column(nullable=false)
	private boolean shipping;
	
	@Column
	private String description;
	
	@Column
	private String feature;
	
	@Column(nullable=false)
	private int stock;
	
	@Column
	private int minOrder;
	
	@Column
	private int maxOrder;
	
	
	
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	public Product( String name, String asin, Category cat_level1, String brand_name, int discount,
			int price, boolean shipping, String description, String feature, int stock, int minOrder, int maxOrder,
			Date date) {
		super();

		this.name = name;
		this.asin = asin;
		this.cat_level1 = cat_level1;
		this.brand_name = brand_name;
		this.discount = discount;
		this.price = price;
		this.shipping = shipping;
		this.description = description;
		this.feature = feature;
		this.stock = stock;
		this.minOrder = minOrder;
		this.maxOrder = maxOrder;
		this.date = date;
	}


	public Product(String name, Category cat_level1, String brand_name, int discount, int price, boolean shipping,
			String description, String feature, int stock, int minOrder, int maxOrder, Date date) {
		super();
		this.name = name;
		this.cat_level1 = cat_level1;
		this.brand_name = brand_name;
		this.discount = discount;
		this.price = price;
		this.shipping = shipping;
		this.description = description;
		this.feature = feature;
		this.stock = stock;
		this.minOrder = minOrder;
		this.maxOrder = maxOrder;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public Category getCat_level1() {
		return cat_level1;
	}

	public void setCat_level1(Category cat_level1) {
		this.cat_level1 = cat_level1;
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
	
}

	