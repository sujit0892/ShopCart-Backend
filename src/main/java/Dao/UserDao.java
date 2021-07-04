package Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shopcart.beans.User;

public interface UserDao extends JpaRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.email= :email and u.password=:password")
	User login(@Param("email") String email, @Param("password") String password);

}
