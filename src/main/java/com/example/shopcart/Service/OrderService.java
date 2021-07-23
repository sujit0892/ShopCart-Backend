package com.example.shopcart.Service;

import java.util.List;

import com.example.shopcart.JSONEntity.CartJSON;
import com.example.shopcart.JSONEntity.OrderJSON;
import com.example.shopcart.beans.Cart;
import com.example.shopcart.beans.Orders;

public interface OrderService {
	
	public Cart addToCart(CartJSON cartJson);
	public boolean removeFromCart(int cart_id);
	public List<Cart> getItemFromCart(String user_id);
	public List<Orders> placeOrder(OrderJSON orderJSON);
	public List<Orders> getOrderByUserId(String userId);
	

}
