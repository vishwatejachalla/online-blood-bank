package com.cognizant.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.model.Address;
import com.cognizant.bloodbank.model.BloodRequest;
import com.cognizant.bloodbank.service.BloodRequestService;

@RestController
public class BloodRequestController {
@Autowired
BloodRequestService bloodRequestService;
@PostMapping("/requirement") 

public void postRequirement(@RequestBody  BloodRequest bloodRequest)

{
	System.err.println("requirement"+bloodRequest);
	
	bloodRequestService.postRequirement(bloodRequest);
	
}

	@GetMapping("/requirement")
	public List<BloodRequest> getRequirement()

	{
		return  bloodRequestService.getRequirement();
		
	}

	
	
}
