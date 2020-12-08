package com.inmobiliaria.services.email.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.inmobiliaria.services.email.model.EmailBody;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender sender;

	public boolean sendEmail(EmailBody emailBody)  {
		return sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
	}
	
	private boolean sendEmailTool(String textMessage, String email,String subject) {
		boolean send = false;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);		
		try {
			helper.setTo(email);
			helper.setText(textMessage, true);
			helper.setSubject(subject);
			sender.send(message);
			send = true;

		} catch (MessagingException e) {

		}
		return send;
	}
}
