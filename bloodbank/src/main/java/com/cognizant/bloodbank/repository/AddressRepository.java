package com.cognizant.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Address;

@Repository

public interface AddressRepository extends JpaRepository<Address, Integer> {
	@Query(value="SELECT distinct addr_state FROM online_blood_bank.address",nativeQuery=true)
	public List<String> getStatesList();
	
	@Query(value="SELECT addr_area FROM online_blood_bank.address where addr_state=:state",nativeQuery=true)
	public List<String> getAreasList(@Param(value="state") String state);
	
	@Query(value="	SELECT addr_pincode FROM online_blood_bank.address where addr_area=:area",nativeQuery=true)
	public List<Integer> getPincodes(@Param(value="area") String area);
	
	@Query(value = "select * from address where addr_pincode =:pincode", nativeQuery = true)
	public Address getByPincode(@Param(value = "pincode")  int pincode);

//	@Query(value = "select * from address where addr_area =:area", nativeQuery = true)
//	public Address getByArea(@Param(value = "area") String area);
}
