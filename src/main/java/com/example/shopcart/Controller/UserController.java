package com.example.shopcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopcart.JSONEntity.AddressJSON;
import com.example.shopcart.JSONEntity.PhoneJSON;
import com.example.shopcart.JSONEntity.UserJSON;
import com.example.shopcart.Service.UserService;
import com.example.shopcart.beans.Address;
import com.example.shopcart.beans.Phone;
import com.example.shopcart.beans.User;

@CrossOrigin(origins="*")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path="/user/register")
	public ResponseEntity<?> register(@RequestBody UserJSON user)
	{
		try
		{
			String user_id = userService.register(user);
			
			return new ResponseEntity<>(user_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/login")
	public ResponseEntity<?> login(@RequestBody User user)
	{
		try
		{
			String user_id = userService.login(user.getEmail(),user.getPassword());
			
			return new ResponseEntity<>(user_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/test")
	public ResponseEntity<?> Test()
	{
		try
		{
			
			System.out.println("test");
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody User user)
	{
		try
		{
			
			boolean val = userService.changePassword(user.getPassword(), user.getUser_id());
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/addAddress")
	public ResponseEntity<?> addAddress(@RequestBody AddressJSON address)
	{
		try
		{
			
			boolean val = userService.addAddress(address);
//			System.out.println(address.getUser_id()+ " " +address.getAddress()+" "+address.isDefault());
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/addPhone")
	public ResponseEntity<?> addPhone(@RequestBody PhoneJSON phone)
	{
		try
		{
			
			boolean val = userService.addPhone(phone);
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/removePhone")
	public ResponseEntity<?> removePhone(@RequestBody String id)
	{
		try
		{
			
			boolean val = userService.removePhone(Integer.parseInt(id));
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/removeAddress")
	public ResponseEntity<?> removeAddress(@RequestBody String id)
	{
		try
		{
			
			boolean val = userService.removeAddress(Integer.parseInt(id));
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/makeDefaultAddress")
	public ResponseEntity<?> removeAddress(@RequestBody AddressJSON address)
	{
		try
		{
			
			boolean val = userService.makeDefaultAddress(address.getId(),address.getUser_id());
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/makeDefaultPhone")
	public ResponseEntity<?> makeDefaultPhone(@RequestBody PhoneJSON phone)
	{
		try
		{
			
			boolean val = userService.makeDefaultPhone(phone.getId(),phone.getUser_id());
			return new ResponseEntity<>(val,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/getUser")
	public ResponseEntity<?> getUser(@RequestBody String user_id)
	{
		try
		{
			
			User user = userService.getUser(user_id);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/getPhone")
	public ResponseEntity<?> getPhone(@RequestBody String user_id)
	{
		try
		{
			
			List<Phone> phone = userService.getPhone(user_id);
			return new ResponseEntity<>(phone,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/getAddress")
	public ResponseEntity<?> getAddress(@RequestBody String user_id)
	{
		try
		{
			
			List<Address> adressd = userService.getAddress(user_id);
			return new ResponseEntity<>(adressd,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
}
