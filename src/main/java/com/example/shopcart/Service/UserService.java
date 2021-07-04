package com.example.shopcart.Service;

import com.example.shopcart.beans.User;

public interface UserService {
		public String register(User user);
		public String login(String email, String password);
}
