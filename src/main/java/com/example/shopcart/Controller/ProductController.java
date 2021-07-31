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

import com.example.shopcart.JSONEntity.ProductJSON;
import com.example.shopcart.JSONEntity.ReviewJSON;
import com.example.shopcart.JSONEntity.UserJSON;
import com.example.shopcart.JSONEntity.productArray;
import com.example.shopcart.Service.ProductService;
import com.example.shopcart.beans.Category;
import com.example.shopcart.beans.Product;

@CrossOrigin(origins="*")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(path="/product/addProduct")
	public ResponseEntity<?> register(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.addProduct(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/removeProduct")
	public ResponseEntity<?> removeProduct(@RequestBody String product)
	{
		try
		{
			boolean product_id = productService.removeProduct(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editName")
	public ResponseEntity<?> editName(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editName(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editBrandName")
	public ResponseEntity<?> editBrandName(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editBrandName(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editShipping")
	public ResponseEntity<?> editShipping(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editShipping(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editDiscount")
	public ResponseEntity<?> editDiscount(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editDiscount(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editPrice")
	public ResponseEntity<?> editPrice(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editPrice(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editDescription")
	public ResponseEntity<?> editDescription(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editDescription(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping(path="/product/editFeature")
	public ResponseEntity<?> editFeature(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editFeature(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/editStock")
	public ResponseEntity<?> editStock(@RequestBody ProductJSON product)
	{
		try
		{
			boolean product_id = productService.editStock(product);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/product/getProductByUSer")
	public ResponseEntity<?> getProductByUSer(@RequestBody String user_id)
	{
		try
		{
			List<Product> product_id = productService.getProductByUser(user_id);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/product/getProductByCat/{cat}")
	public ResponseEntity<?> getProductByCat(@PathVariable String cat)
	{
		try
		{
			System.out.println(cat);
			List<Product> product_id = productService.getProductByCat(Integer.parseInt(cat));
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/product/getCategory")
	public ResponseEntity<?> getCategory()
	{
		try
		{
			List<Category> product_id = productService.getCategory();
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path="/product/{product_id}")
	public ResponseEntity<?> getProductById(@PathVariable String product_id)
	{
		try
		{
			Product product = productService.getProductById(product_id);
			
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/addReview")
	public ResponseEntity<?> addReview(@RequestBody ReviewJSON review)
	{
		try
		{
			boolean product_id = productService.addreview(review);
			
			return new ResponseEntity<>(product_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/product/getProductArray")
	public ResponseEntity<?> getProductArray(@RequestBody productArray products)
	{
		try
		{
			List<Product> product = productService.getProductArray(products);
			
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
	

}
