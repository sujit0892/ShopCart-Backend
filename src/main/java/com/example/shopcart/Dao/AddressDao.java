package com.example.shopcart.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopcart.beans.Address;
import com.example.shopcart.beans.Phone;

public interface AddressDao extends JpaRepository<Address, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Address set isDefault=:val where user_id=:user_id")
	void makeDefaultFalse(@Param("val")boolean val,@Param("user_id") String user_id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Address set isDefault=:val where address_id=:address_id")
	void makeDefault(@Param("val")boolean val,@Param("address_id") int address_id);
	
	@Query("Select a from Address a where user_id=:user_id")
	List<Address> getAddress(@Param("user_id") String user_id);

}
