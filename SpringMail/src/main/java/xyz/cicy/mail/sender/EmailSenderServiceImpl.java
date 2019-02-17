package xyz.cicy.mail.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderServiceImpl implements EmailSenderService
{
	@Autowired
	private JavaMailSender mailSender;

	private static final String FROM = "lawrencezhu2018@outlook.com";

	private static final String TO = "lawrencezhu2018@gmail.com";

	@Override
	public void send(String text, String filename) throws MessagingException
	{
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		ClassPathResource resource = new ClassPathResource(filename);

		messageHelper.setFrom(FROM);
		messageHelper.setTo(TO);
		messageHelper.setSubject("Spring mail");
		messageHelper.setText("<h1>Hello, World!" + text + "<h1>", true);
		messageHelper.addInline("cc.jpg",resource);
		messageHelper.addAttachment("wall.jpg", resource);

		mailSender.send(message);
	}
}
