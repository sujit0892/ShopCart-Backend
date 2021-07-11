package com.example.shopcart.Service;

import java.util.List;

import com.example.shopcart.JSONEntity.AddressJSON;
import com.example.shopcart.JSONEntity.PhoneJSON;
import com.example.shopcart.JSONEntity.UserJSON;
import com.example.shopcart.beans.Address;
import com.example.shopcart.beans.Phone;
import com.example.shopcart.beans.User;

public interface UserService {
		public String register(UserJSON user);
		public String login(String email, String password);
		public User getUser(String user_id);
		public List<Phone> getPhone(String user_id);
		public List<Address> getAddress(String user_id);
		public boolean changePassword(String Password,String user_id);
		public boolean addAddress(AddressJSON ad);
		public boolean addPhone(PhoneJSON ph);
		public boolean removeAddress(int id);
		public boolean removePhone(int id);
		public boolean makeDefaultAddress(int id,String user_id);
		public boolean makeDefaultPhone(int id,String user_id);
}
