package com.example.shopcart.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopcart.beans.Phone;

public interface PhoneDao extends JpaRepository<Phone, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE Phone set isDefault=:val where user_id=:user_id")
	void makeDefaultFalse(@Param("val")boolean val,@Param("user_id") String user_id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Phone set isDefault=:val where phone_id=:phone_id")
	void makeDefault(@Param("val")boolean val,@Param("phone_id") int phone_id);
	
	@Query("Select p from Phone p where user_id=:user_id")
	List<Phone> getPhone(@Param("user_id") String user_id);
	
}
