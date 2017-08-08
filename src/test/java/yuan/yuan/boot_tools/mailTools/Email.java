package yuan.yuan.boot_tools.mailTools;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Email {

	@Test
	public void sendEmail() {
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("");
		
		
		
		sender.send(mailMessage());
	}
	
	private SimpleMailMessage mailMessage() {
		SimpleMailMessage mailMessage = new  SimpleMailMessage();
		mailMessage.setFrom("");
		mailMessage.setText("");
		mailMessage.setTo("");
		return mailMessage;
	}
}
