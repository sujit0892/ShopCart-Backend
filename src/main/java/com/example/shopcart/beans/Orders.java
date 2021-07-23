package com.example.shopcart.beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	@Column(nullable = false)
	private int quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="phone")
	private Phone phone;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="address")
	private Address address;
	

	@Column(nullable=false)
	private int status;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category")
	private Category category;
	
	
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Orders(Product product, User user, Phone phone, Address address, int status, Category category, Date date) {
		super();
		this.product = product;
		this.user = user;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.category = category;
		this.date = date;
	}







	public int getOrderid() {
		return orderid;
	}







	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}







	public Category getCategory() {
		return category;
	}







	public void setCategory(Category category) {
		this.category = category;
	}







	public Phone getPhone() {
		return phone;
	}



	public void setPhone(Phone phone) {
		this.phone = phone;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCart_id() {
		return orderid;
	}

	public void setCart_id(int cart_id) {
		this.orderid = cart_id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
