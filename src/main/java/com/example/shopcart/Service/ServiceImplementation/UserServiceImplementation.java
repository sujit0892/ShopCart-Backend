package com.example.shopcart.Service.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopcart.Dao.AddressDao;
import com.example.shopcart.Dao.PhoneDao;
import com.example.shopcart.Dao.UserDao;
import com.example.shopcart.JSONEntity.AddressJSON;
import com.example.shopcart.JSONEntity.PhoneJSON;
import com.example.shopcart.JSONEntity.UserJSON;
import com.example.shopcart.Service.UserService;
import com.example.shopcart.beans.Address;
import com.example.shopcart.beans.Phone;
import com.example.shopcart.beans.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PhoneDao phoneDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Override
	public String register(UserJSON us) {
		// TODO Auto-generated method stub
		String user_id=null;
		try {
			User user  = new User(us.getEmail(),us.getPassword(),us.getName(),true);
			userDao.save(user);
			phoneDao.save(new Phone(us.getPhone(),true,user));
			addressDao.save(new Address(us.getAddress(),true,user));
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

	@Override
	public boolean changePassword(String Password,String user_id) {
		// TODO Auto-generated method stub
		try {
			User user  = userDao.findById(user_id).get();
			user.setPassword(Password);
			userDao.save(user);
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean addAddress(AddressJSON ad) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.findById(ad.getUser_id()).get();
			Address address = new Address(ad.getAddress(),false,user);
			addressDao.save(address);
			if(ad.isDefault())
				makeDefaultAddress(address.getAddress_id(), ad.getUser_id());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean addPhone(PhoneJSON ph) {
		// TODO Auto-generated method stub
		try {
			User user = userDao.findById(ph.getUser_id()).get();
			Phone phone = new Phone(ph.getPhone(),false,user);
			phoneDao.save(phone);
			if(ph.isDefault())
				makeDefaultPhone(phone.getPhone_id(), ph.getUser_id());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean removeAddress(int id) {
		// TODO Auto-generated method stub
		try {
			Address ad = addressDao.findById(id).get();
			addressDao.delete(ad);
			if(ad.isDefault())
			{
				List<Address> ls = addressDao.getAddress(ad.getUser().getUser_id());
				if(ls.size()!=0)
					makeDefaultAddress(ls.get(0).getAddress_id(),ad.getUser().getUser_id());	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean removePhone(int id) {
		// TODO Auto-generated method stub
		try {
			Phone phone = phoneDao.findById(id).get();
			phoneDao.delete(phone);
			if(phone.isDefault())
			{
				List<Phone> ls = phoneDao.getPhone(phone.getUser().getUser_id());
				if(ls.size()!=0)
					makeDefaultPhone(ls.get(0).getPhone_id(),phone.getUser().getUser_id());	
			}
				
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean makeDefaultAddress(int id, String user_id) {
		// TODO Auto-generated method stub
		try {
			addressDao.makeDefaultFalse(false, user_id);
			addressDao.makeDefault(true, id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean makeDefaultPhone(int id, String user_id) {
		// TODO Auto-generated method stub
		try {
			phoneDao.makeDefaultFalse(false, user_id);
			phoneDao.makeDefault(true, id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public User getUser(String user_id) {
		// TODO Auto-generated method stub
		
		try {
			return userDao.findById(user_id).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Phone> getPhone(String user_id) {
		// TODO Auto-generated method stub
		try {
			return phoneDao.getPhone(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Address> getAddress(String user_id) {
		// TODO Auto-generated method stub
		try {
			return addressDao.getAddress(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}


	
	

}
