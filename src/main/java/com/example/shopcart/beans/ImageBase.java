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
public class ImageBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int image_id;

	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product")
	private Product product;
	
	@Column(nullable=false)
	private String url;
	
	

	public ImageBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageBase(Product product, String url) {
		super();
		this.product = product;
		this.url = url;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
