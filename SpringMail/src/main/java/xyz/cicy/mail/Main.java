package xyz.cicy.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.mail.config.MailConfig;
import xyz.cicy.mail.sender.EmailSenderService;

import javax.mail.MessagingException;

public class Main
{
	public static void main(String[] args) throws MessagingException
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(MailConfig.class);
		EmailSenderService senderService = context.getBean(EmailSenderService.class);
		senderService.send("this is zz", "wallhaven-714239.jpg");
	}
}
