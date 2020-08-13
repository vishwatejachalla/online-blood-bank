package com.cognizant.bloodbank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
	@Query(value="select * from user where us_firstname=:value",nativeQuery=true)

	public Optional<User> findByFirstname1(@Param (value="value")String firstname);
	 
	@Query(value="select * from user  where us_pincode=:pincode and us_bloodgroup=:bloodgroup",nativeQuery=true)
	public List<User> getDonorList(@Param(value = "bloodgroup") String bloodgroup,@Param(value = "pincode")int pincode);

	User findByFirstname(String user);
	

}
