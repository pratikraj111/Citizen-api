package com.RoadIsland.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoadIsland.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	
	public Citizen findByEmail(String email);
	public Citizen findByEmailAndPwd(String email, String pwd);

}
