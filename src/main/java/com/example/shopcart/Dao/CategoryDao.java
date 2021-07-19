package com.example.shopcart.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopcart.beans.Category;
import com.example.shopcart.beans.Phone;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
