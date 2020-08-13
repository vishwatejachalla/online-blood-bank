package com.cognizant.bloodbank.controller;

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

import com.cognizant.bloodbank.BloodbankApplication;
import com.cognizant.bloodbank.exception.UserAlreadyExistsException;
import com.cognizant.bloodbank.model.Address;
import com.cognizant.bloodbank.model.BloodRequest;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.AddressRepository;
import com.cognizant.bloodbank.security.AppUserDetailsService;
import com.cognizant.bloodbank.service.UserService;

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
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodbankApplication.class);

	// @Autowired
	// InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Autowired
	AppUserDetailsService appuserDetailsService;

	@Autowired
	UserService userService;

	@GetMapping("/states")
	public List<String> getStateList()

	{
		return userService.getStatesList();

	}

	@GetMapping("/areas/{state}")
	public List<String> getAreasList(@PathVariable String state)

	{
		System.err.println(state);
		String st = state.substring(3);
		System.err.println(st);
		return userService.getAreasList(st);

	}

	@GetMapping("/pincodes/{area}")
	public List<Integer> getPincodes(@PathVariable String area)

	{
		System.err.println("yeswanth"+area);
		String st = area.substring(3);
		System.err.println(st);
		return userService.getPincodes(st);

	}

	@GetMapping("/{bloodgroup}/{pincode}")
	public List<User> getDonorList(@PathVariable String bloodgroup, @PathVariable int pincode)

	{
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
