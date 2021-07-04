package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopcart.Service.UserService;
import com.example.shopcart.beans.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path="/user/register")
	public ResponseEntity<?> register(@RequestBody User user)
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
	public ResponseEntity<?> login(@RequestParam String email,String passord)
	{
		try
		{
			String user_id = userService.login(email, passord);
			
			return new ResponseEntity<>(user_id,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/user/login")
	public ResponseEntity<?> Test()
	{
		try
		{
			
			
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
