package com.cognizant.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.Address;
import com.cognizant.bloodbank.model.BloodRequest;
import com.cognizant.bloodbank.repository.AddressRepository;
import com.cognizant.bloodbank.repository.BloodRequestRepository;
@Service
public class BloodRequestService {

	@Autowired
	BloodRequestRepository bloodRequestRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	public void postRequirement(BloodRequest bloodRequest) {
		// TODO Auto-generated method stub
		System.err.println("bloodrequest"+bloodRequest);
		//Address address = bloodRequest.getAddress();
		
		//int pincode = bloodRequest.getAddress().getPincode();
//		System.err.println("pin..."+pincode);
//		
//		Address adress2 = addressRepository.getByPincode(pincode);
//		System.err.println("add2"+adress2);
//		bloodRequest.setAddress(adress2);
		bloodRequestRepository.save(bloodRequest);
	}


	public List<BloodRequest> getRequirement() {
		// TODO Auto-generated method stub
	return bloodRequestRepository.findAll();	
	}
	
}
