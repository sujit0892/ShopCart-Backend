package com.example.shopcart.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(length=64)
	private String asin;
	
	@Column(nullable=false)
	private String name;
	

	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category")
	private Category cat_level1;
	

	@Column
	private String brand_name;
	
	
	@Column(nullable=false)
	private int price;

	
	@Column(length=3000)
	private String description;
	
	@Column(length=3000)
	private String feature;
	
	@Column(nullable=false)
	private int stock;
	
	@Column
	private float rating=0;
	
	@Fetch(value = FetchMode.JOIN) 
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ImageBase> imageBase;
	
	@OneToMany(mappedBy = "product")
	private List<Review> reviews;
	

	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Category cat_level1, String brand_name, int price, 
			String description, String feature, int stock) {
		super();
		this.name = name;
		this.cat_level1 = cat_level1;
		this.brand_name = brand_name;
		this.price = price;
		this.description = description;
		this.feature = feature;
		this.stock = stock;


		imageBase = new ArrayList<>();
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<ImageBase> getImages() {
		return imageBase;
	}

	public void setImages(List<ImageBase> images) {
		this.imageBase.addAll(images);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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




	
}

	