package com.example.shopcart.Service.ServiceImplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopcart.Dao.CategoryDao;
import com.example.shopcart.Dao.ImageBaseDao;
import com.example.shopcart.Dao.ProductDao;
import com.example.shopcart.Dao.ReviewDao;
import com.example.shopcart.Dao.UserDao;
import com.example.shopcart.JSONEntity.ProductJSON;
import com.example.shopcart.JSONEntity.ReviewJSON;
import com.example.shopcart.JSONEntity.productArray;
import com.example.shopcart.Service.ProductService;
import com.example.shopcart.beans.Category;
import com.example.shopcart.beans.ImageBase;
import com.example.shopcart.beans.Product;
import com.example.shopcart.beans.Review;
import com.example.shopcart.beans.User;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ImageBaseDao imageBaseDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	
	@Override
	public boolean addProduct(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.findById(pd.getUser_id()).get();
			Category cat = categoryDao.findById(pd.getCat_id()).get();
			Product product = new Product(pd.getName(),cat,pd.getBrand_name(),pd.getPrice(),pd.getDescription(),
					pd.getFeature(), pd.getStock());
			productDao.save(product);
			for(String url:pd.getImages())
			{
				ImageBase im = new ImageBase(product, url);
				imageBaseDao.save(im);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		return false;
	}


	@Override
	public boolean removeProduct(String product_id) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(product_id).get();
			productDao.delete(product);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editName(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
			product.setName(pd.getName());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editPrice(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
			product.setPrice(pd.getPrice());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editBrandName(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
			product.setBrand_name(pd.getBrand_name());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editDescription(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
			product.setDescription(pd.getDescription());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
		return false;
	}


	@Override
	public boolean editFeature(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
			product.setFeature(pd.getFeature());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editStock(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
			product.setStock(pd.getStock());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editDiscount(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
//			product.setDiscount(pd.getDiscount());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public boolean editShipping(ProductJSON pd) {
		// TODO Auto-generated method stub
		try {
			Product product = productDao.findById(pd.getProduct_id()).get();
//			product.setShipping(pd.isShipping());
			productDao.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public List<Product> getProductByUser(String user_id) {
		// TODO Auto-generated method stub
		try {
			return productDao.getProductByUser(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}


	@Override
	public List<Product> getProductByCat(int cat) {
		// TODO Auto-generated method stub
		try {
			List<Product> products = productDao.getProductByCat(cat);
			System.out.println(products.get(0).getImages());
			return products;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}


	@Override
	public List<Category> getCategory() {
		try {
			return categoryDao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}


	@Override
	public Product getProductById(String product_id) {
		// TODO Auto-generated method stub
		try {
			return productDao.findById(product_id).get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public boolean addreview(ReviewJSON reviewJson) {
		// TODO Auto-generated method stub
		try {
//			System.out.println(reviewJson.getProduct_id());
			Product product = productDao.findById(reviewJson.getProduct_id()).get();
			User user = userDao.findById(reviewJson.getUser_id()).get();
			Review review = new Review(product, user, reviewJson.getRevview(), Float.parseFloat(reviewJson.getRating()),product.getCat_level1()); 
			reviewDao.save(review);
			productDao.updateRating(product.getAsin(),product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}


	@Override
	public List<Product> getProductArray(productArray product) {
		// TODO Auto-generated method stub3
		try {
			
			List<Product> out = new ArrayList<>();
			for(String product_id:product.getProduct_id())
			{
				out.add(productDao.findById(product_id).get());
			}
			return out;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	


}
