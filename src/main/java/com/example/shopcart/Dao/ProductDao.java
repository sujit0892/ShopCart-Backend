package com.example.shopcart.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopcart.beans.Phone;
import com.example.shopcart.beans.Product;

public interface ProductDao extends JpaRepository<Product, String> {
	@Query("Select p from Product p where user_id=:user_id")
	List<Product> getProductByUser(@Param("user_id") String user_id);
	
	@Query("Select p from Product p where category=:cat")
	List<Product> getProductByCat(@Param("cat") int cat);
	
	@Transactional
	@Modifying
	@Query("update Product set rating = (select round(avg(rating),1) from Review where product=:product) where asin=:asin")
	void updateRating(@Param("asin") String asin,@Param("product") Product product);
	
	
}
