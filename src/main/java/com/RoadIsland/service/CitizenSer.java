package com.RoadIsland.service;

import org.springframework.stereotype.Service;

import com.RoadIsland.entity.Citizen;

@Service
public interface CitizenSer {
	
	public String RegCitizen(Citizen c);
	public Citizen loginCitizen(String email, String pwd);
	public Boolean forgotPwd(String email);
	

}
