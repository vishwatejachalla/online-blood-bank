package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.BloodRequest;

@Repository

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Integer>   {

//	@Query(value="select * from user where us_id IN (select ua_us_id_fk from user_address join address on ua_addr_id_fk=addr_id where addr_pincode=:pincode) and us_bloodgroup=:bloodgroup",nativeQuery=true)
//	public List<User> getDonorList(@Param(value = "bloodgroup") String bloodgroup,@Param(value = "pincode")int pincode);
	
	
}
