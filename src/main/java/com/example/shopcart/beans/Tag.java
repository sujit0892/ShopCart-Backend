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

@Entity
@Table
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tag_id;
	
	@Column(nullable = false)
	private String tag;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product")
	private Product product;

	public Tag(String tag, Product product) {
		super();
		this.tag = tag;
		this.product = product;
	}

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
