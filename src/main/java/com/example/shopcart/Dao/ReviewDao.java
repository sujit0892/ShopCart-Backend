package com.example.shopcart.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopcart.beans.Review;

public interface ReviewDao extends JpaRepository<Review, Integer> {

}
