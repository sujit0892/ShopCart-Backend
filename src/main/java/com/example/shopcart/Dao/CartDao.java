package com.example.shopcart.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shopcart.beans.Cart;
import com.example.shopcart.beans.Phone;

public interface CartDao extends JpaRepository<Cart, Integer> {

	@Query("Select p from Cart p where user_id=:user_id")
	List<Cart> getCart(@Param("user_id") String user_id);
	
	
	
}
