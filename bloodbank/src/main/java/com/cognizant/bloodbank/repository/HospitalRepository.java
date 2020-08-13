package com.cognizant.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Hospitals;
@Repository
public interface HospitalRepository extends JpaRepository<Hospitals, Integer> {
	
	
	@Query(value="select hp_name from hospital  where hp_pincode=:pincode",nativeQuery=true)
	public List<String> getHospitalList(@Param(value = "pincode")int pincode);
	
	@Query(value="select hp_id from hospital where hp_name=:name and hp_pincode=:pincode",nativeQuery=true)
	public int getHospitalId(@Param(value = "name")String name,@Param(value = "pincode")int pincode);
	
	Hospitals findByName(String name);

}
