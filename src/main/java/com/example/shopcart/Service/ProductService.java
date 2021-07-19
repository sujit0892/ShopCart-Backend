package com.example.shopcart.Service;

import java.util.List;

import com.example.shopcart.JSONEntity.ProductJSON;
import com.example.shopcart.beans.Category;
import com.example.shopcart.beans.Product;

public interface ProductService {
	
	public boolean addProduct(ProductJSON product);
	public boolean removeProduct(String product_id);
	public boolean editName(ProductJSON pd);
	public boolean editPrice(ProductJSON pd);
	public boolean editBrandName(ProductJSON pd);
	public boolean editDescription(ProductJSON pd);
	public boolean editFeature(ProductJSON pd);
	public boolean editStock(ProductJSON pd);
	public boolean editDiscount(ProductJSON pd);
	public boolean editShipping(ProductJSON pd);
	public List<Product> getProductByUser(String user_id);
	public List<Product> getProductByCat(int cat);
	
	public List<Category> getCategory();
}
