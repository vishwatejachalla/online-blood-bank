package com.cognizant.authenticationservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getDonorList(String bg,int pc)
	{
		return userRepository.getDonorList(bg, pc);
	}


}
