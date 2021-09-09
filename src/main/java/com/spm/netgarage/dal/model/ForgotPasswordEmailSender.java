package com.spm.netgarage.dal.model;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class ForgotPasswordEmailSender {
	
	@Autowired
	JavaMailSender mailSender;
	
	private String toAddress;
	private final String fromAddress = "netgarage2021@gmail.com";
	private final String senderName = "NetGarage Team";
	private final String subject = "Reset your password!";
	private String content = "<h4>Reset your password, </h4><br>"
			+ "if you've lost your password or wish to reset it, <br>"
			+ "use the link below to get started!"
			+ "<h3><a href=\"[[URL]]\" target=\"_self\">Reset Password</a></h3><br>"
			+ "Thank you,<br>"
			+ "NetGarage team.<br>";
			
	
	private MimeMessage message;
	private MimeMessageHelper helper;
	private String userID;
	private String email;
	
	public ForgotPasswordEmailSender() {
//		userID = null;
//		email = null;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void sendEmail() throws UnsupportedEncodingException, MessagingException {
		
		 message = mailSender.createMimeMessage();
		 helper = new MimeMessageHelper(message);
		 
		 toAddress = getEmail();
		 
		 helper.setFrom(fromAddress, senderName);
		 helper.setTo(toAddress);
		 helper.setSubject(subject);
			

		 String verifyURL = "http://localhost:3000/reset-password/"+userID;
		 content = content.replace("[[URL]]", verifyURL);
		 helper.setText(content, true);
			
		 mailSender.send(message);
			
		 System.out.println("Email has been sent");
			
		
	}
	

}
