package kodlamaio.ReCapProject.core.utilities.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.entities.concretes.Customer;

@Service
@EnableAsync
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendSimpleEmail(String mailTo, String body, String subject) throws MailException, InterruptedException {
		
		System.out.println("sleep");
		Thread.sleep(10000);
		
		System.out.println("sending email");
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("mailval.spring@gmail.com");
		message.setTo(mailTo);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("email sent");
		
	}
}
