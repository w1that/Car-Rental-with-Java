package kodlamaio.ReCapProject.core.utilities.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.entities.concretes.Customer;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String mailTo, String body, String subject) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("mailval.spring@gmail.com");
		message.setTo(mailTo);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("mail send...");
		
	}
}
