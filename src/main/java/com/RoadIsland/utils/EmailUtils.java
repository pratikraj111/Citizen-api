package com.RoadIsland.utils;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean SendEmail(String to, String Subject, String body)
	{
		MimeMessage message=mailsender.createMimeMessage();
			
		MimeMessageHelper helper=new MimeMessageHelper(message);
			
		boolean isSent=false;
		
		                   try {
							helper.setTo(to);
							 helper.setSubject(Subject);
							 helper.setText(body, true);
						 
							 mailsender.send(message);
								 
							 isSent=true;
						} catch (MessagingException e) {
							
							e.printStackTrace();
						}         
		
		return isSent;
	}
		
}

