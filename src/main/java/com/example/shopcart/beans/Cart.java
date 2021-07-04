package com.example.shopcart.beans;

import javax.persistence.*;

@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	
	@Column(nullable = false)
	private int quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User user;

	public Cart(int quantity, Product product, User user) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
	
	
	

}
