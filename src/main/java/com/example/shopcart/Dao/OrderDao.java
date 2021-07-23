package com.example.shopcart.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shopcart.beans.Cart;
import com.example.shopcart.beans.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer> {
	@Query("Select p from Orders p where user_id=:user_id")
	List<Orders> getOrder(@Param("user_id") String user_id);
}
