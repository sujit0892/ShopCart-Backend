package com.example.shopcart.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shopcart.beans.Phone;
import com.example.shopcart.beans.Product;

public interface ProductDao extends JpaRepository<Product, String> {
	@Query("Select p from Product p where user_id=:user_id")
	List<Product> getProductByUser(@Param("user_id") String user_id);
	
	@Query("Select p from Product p where category=:cat")
	List<Product> getProductByCat(@Param("cat") int cat);
}
