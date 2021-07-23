package com.example.shopcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopcart.JSONEntity.CartJSON;
import com.example.shopcart.JSONEntity.OrderJSON;
import com.example.shopcart.JSONEntity.ProductJSON;
import com.example.shopcart.Service.OrderService;
import com.example.shopcart.beans.Cart;
import com.example.shopcart.beans.Orders;

@CrossOrigin(origins="*")
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@PostMapping(path="/cart/addToCart")
	public ResponseEntity<?> addToCart(@RequestBody CartJSON cartJSON)
	{
		try
		{
			Cart cart_id = orderService.addToCart(cartJSON);
			
			return new ResponseEntity<>(cart_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/cart/removeFromCart")
	public ResponseEntity<?> removeFromCart(@RequestBody String cart_id)
	{
		try
		{
			boolean out = orderService.removeFromCart(Integer.parseInt(cart_id));
			
			return new ResponseEntity<>(out,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/cart/{user_id}")
	public ResponseEntity<?> getCart(@PathVariable String user_id)
	{
		try
		{
			List<Cart> out = orderService.getItemFromCart(user_id);
			return new ResponseEntity<>(out,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/order/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestBody OrderJSON orderJSON)
	{
		try
		{

			
			List<Orders> orders = orderService.placeOrder(orderJSON);
			return new ResponseEntity<>(orders,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/order/{user_id}")
	public ResponseEntity<?> getOrder(@PathVariable String user_id)
	{
		try
		{
			
			List<Orders> out = orderService.getOrderByUserId(user_id);
				
			return new ResponseEntity<>(out,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
