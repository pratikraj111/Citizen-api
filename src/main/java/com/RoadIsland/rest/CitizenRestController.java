package com.RoadIsland.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RoadIsland.entity.Citizen;
import com.RoadIsland.service.CitizenSevImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class CitizenRestController {
	
	@Autowired 
	private CitizenSevImpl citizenSerImpl;
	
	@GetMapping("/register")
	public String registerPage(@RequestBody Citizen c)
	{
		return "Registration Page";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Citizen c)
	{
		return citizenSerImpl.RegCitizen(c);
	}
	
	@PostMapping("/login")
	public String handleLogin(@RequestBody Citizen c,HttpServletRequest req)
	{
		
		Citizen c1=citizenSerImpl.loginCitizen(c.getEmail(), c.getPwd());
		
		if(c1== null)
		{
			return "Invalid Credentials";
			 
		}
		
		HttpSession session=req.getSession(true);
		session.setAttribute("CID", c1.getCid());
		
		return "redirect:dashboard";
	}
	
	@GetMapping("/dashboard")
	public String buildDashboard(HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		Integer cid=(Integer)session.getAttribute("CID");
		
		
		return "This is dashBoard";
	}
	
	@GetMapping("/recover-pwd")
	public String recoverPwd(@RequestParam String email)
	{
		Boolean stts=citizenSerImpl.forgotPwd(email);
		if(stts)
		{
			return "password sent to mail.";
		}
		else
		{
			return "Invalid email Id";
		}
		
	}
	
	

}
