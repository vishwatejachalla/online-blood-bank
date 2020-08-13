package com.cognizant.bloodbank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.Address;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.AddressRepository;
import com.cognizant.bloodbank.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;
	
	public List<User> getDonorList(String bg,int pc)
	{
		return userRepository.getDonorList(bg, pc);
	}

	public List<String> getStatesList() {
		// TODO Auto-generated method stub
		return addressRepository.getStatesList();
	}

	
	public List<String> getAreasList(String state) {
		// TODO Auto-generated method stub
		return addressRepository.getAreasList(state);
	}
	
	public List<Integer> getPincodes(String area) {
		// TODO Auto-generated method stub
		return addressRepository.getPincodes(area);
	}

}
