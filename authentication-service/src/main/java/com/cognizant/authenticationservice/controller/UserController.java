package com.cognizant.authenticationservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.AuthenticationServiceApplication;
import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.authenticationservice.service.UserService;



//@RestController
//public class UserController {

/*@GetMapping("/test/{bg}/{pc}")
public List<User> getDonorList(@PathVariable String bg,@PathVariable int pc)
{
	return userService.getDonorList(bg, pc);
}
}*/
@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceApplication.class);

	// @Autowired
	// InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Autowired
	AppUserDetailsService appuserDetailsService;

	@Autowired
	UserService userService;



	@GetMapping("/{bloodgroup}/{pincode}")
	public List<User> getDonorList(@PathVariable String bloodgroup, @PathVariable int pincode)

	{
		System.out.println("-------------------------------------------------------------------------");
		System.err.println(userService.getDonorList(bloodgroup, pincode));
		return userService.getDonorList(bloodgroup, pincode);

	}

	@PostMapping("/users")
	public boolean signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		
		System.err.println("User is"+user);
		appuserDetailsService.signup(user);
		return true;
	}

}
