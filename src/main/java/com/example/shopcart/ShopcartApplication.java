package com.example.shopcart;

import java.util.Scanner;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.shopcart.Dao.CategoryDao;
import com.example.shopcart.Dao.ImageBaseDao;
import com.example.shopcart.Dao.ProductDao;
import com.example.shopcart.Dao.ReviewDao;
import com.example.shopcart.Dao.UserDao;
import com.example.shopcart.beans.Category;
import com.example.shopcart.beans.ImageBase;
import com.example.shopcart.beans.Product;

@SpringBootApplication
public class ShopcartApplication {

	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ImageBaseDao imageBaseDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ShopcartApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
//	       Product p = productDao.findAll().get(0);
//	       ImageBase i = new ImageBase(p,"https://images-na.ssl-images-amazon.com/images/I/41ax2HXyPsL.jpg");
//	       imageBaseDao.save(i);
	       //closes the scanner   
	    	
	    	
	      };
	   }

}
