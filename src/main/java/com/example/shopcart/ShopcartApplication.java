package com.example.shopcart;

import java.util.Scanner;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.shopcart.Dao.CategoryDao;
import com.example.shopcart.Dao.ProductDao;
import com.example.shopcart.Dao.ReviewDao;
import com.example.shopcart.Dao.UserDao;
import com.example.shopcart.beans.Category;

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
	
	
	public static void main(String[] args) {
		SpringApplication.run(ShopcartApplication.class, args);
	}
	
//	@Bean
//	InitializingBean sendDatabase() {
//	    return () -> {
//	    	Scanner sc = new Scanner(new File("F:\\CSVDemo.csv"));  
//	    	sc.useDelimiter(",");   //sets the delimiter pattern  
//	    	while (sc.hasNext())  //returns a boolean value  
//	    	{  
//	    		System.out.print(sc.next());  //find and returns the next complete token from this scanner  
//	    	}   
//	    		sc.close();  //closes the scanner   
//	    	
//	    	
//	      };
//	   }

}
