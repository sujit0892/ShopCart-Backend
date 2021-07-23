package com.example.shopcart.Service.ServiceImplementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.shopcart.Dao.AddressDao;
import com.example.shopcart.Dao.CartDao;
import com.example.shopcart.Dao.CategoryDao;
import com.example.shopcart.Dao.OrderDao;
import com.example.shopcart.Dao.PhoneDao;
import com.example.shopcart.Dao.ProductDao;
import com.example.shopcart.Dao.UserDao;
import com.example.shopcart.JSONEntity.CartJSON;
import com.example.shopcart.JSONEntity.OrderJSON;
import com.example.shopcart.Service.OrderService;
import com.example.shopcart.beans.Address;
import com.example.shopcart.beans.Cart;
import com.example.shopcart.beans.Category;
import com.example.shopcart.beans.Orders;
import com.example.shopcart.beans.Phone;
import com.example.shopcart.beans.Product;
import com.example.shopcart.beans.User;


@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	@Override
	public Cart addToCart(CartJSON cartJson) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(cartJson.getProduct_id()).get();
			User user = userDao.findById(cartJson.getUser_id()).get();
			Category category = categoryDao.findById(Integer.parseInt(cartJson.getCat_id())).get();
			Cart cart = new Cart(cartJson.getQuantity(), product, user, category);
			cartDao.save(cart);
			return cart;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean removeFromCart(int cart_id) {
		// TODO Auto-generated method stub
		try {
			Cart cart= cartDao.findById(cart_id).get();
			cartDao.delete(cart);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Cart> getItemFromCart(String user_id) {
		// TODO Auto-generated method stub
		try {
			return cartDao.getCart(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Orders> placeOrder(OrderJSON orderJSON) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.findById(orderJSON.getUser_id()).get();
			Address address = addressDao.findById(orderJSON.getAddress_id()).get();
			Phone phone = phoneDao.findById(orderJSON.getPhone_id()).get();
			for(int id:orderJSON.getCart_id())
			{
				Cart cart = cartDao.findById(id).get();
				Product product = cart.getProduct();
				Category category = cart.getCategory();
				Orders order = new Orders(product, user, phone, address, 0, category, new Date());
				orderDao.save(order);
				cartDao.delete(cart);
			}
		
			return orderDao.getOrder(orderJSON.getUser_id());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Orders> getOrderByUserId(String userId) {
		// TODO Auto-generated method stub
		try {
			return orderDao.getOrder(userId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	

}
