package com.example.shopcart.Service.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.shopcart.Service.UserService;
import com.example.shopcart.beans.User;

import Dao.UserDao;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		String user_id=null;
		try {
			userDao.save(user);
			user_id = user.getUser_id();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user_id;
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		String user_id=null;
		try {
			User user = userDao.login(email, password);
			if(user!=null)
				user_id = user.getUser_id();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user_id;
	}

}
