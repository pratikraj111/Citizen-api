package com.RoadIsland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoadIsland.entity.Citizen;
import com.RoadIsland.repo.CitizenRepo;
import com.RoadIsland.utils.EmailUtils;

@Service
public class CitizenSevImpl implements CitizenSer {
	
	@Autowired
	private CitizenRepo crepo;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String RegCitizen(Citizen c) {
		Citizen obj=crepo.findByEmail(c.getEmail());
		
		if(obj!=null)
		{
			return "Email is duplicated..";
		}
		
		Citizen c1=crepo.save(c);
		if(c1.getCid()!=null)
		{
			return "Registration successfull..!";
		}
		return "Registration failed..!";
	}

	@Override
	public Citizen loginCitizen(String email, String pwd) {
		
		return crepo.findByEmailAndPwd(email, pwd);
	}

	@Override
	public Boolean forgotPwd(String email) {
		Citizen obj=crepo.findByEmail(email);
		if(obj == null)
		{
			return false;
		}
		String subject="Recover password- Pratik";
		String body="<h1> Your Password: "+obj.getPwd()+"</h1>";
		
		return emailUtils.SendEmail(subject, body, email);
	}

}
