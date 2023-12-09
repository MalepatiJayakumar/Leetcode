package com.highradius.controller;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishController {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@RequestMapping(value="/send-morning-mail",method=RequestMethod.GET)
	public ResponseEntity<String> sendMorningMail() {
		try {
			String[] toEmails = new String[] { "m.reddy@highradius.com" };
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(fromEmail);
			helper.setCc(toEmails);
			helper.setSubject("Open it to konw it");
			helper.setSentDate(new Date());
			helper.setText("Hi , Good morning");
			sender.send(message);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception  :: " + e);
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}