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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product")
	@JsonIgnore
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
	private User user;
	
	
	@Column(length=3000)
	private String review;
	
	
	
	@Column
	private float rating;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category")
	private Category category;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Review( Product product, User user, String review, float rating, Category category) {
		super();

		this.product = product;
		this.user = user;
		this.review = review;
	
		this.rating = rating;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}




	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	
	
	
	
}
