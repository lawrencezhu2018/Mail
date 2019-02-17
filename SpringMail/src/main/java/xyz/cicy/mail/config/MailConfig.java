package xyz.cicy.mail.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "xyz.cicy.*")
public class MailConfig
{
	@Bean
	public JavaMailSenderImpl mailSender(Properties properties)
	{
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(properties.getProperty("mailserver.host"));
		mailSender.setPort(Integer.parseInt(properties.getProperty("mailserver.port")));
		mailSender.setUsername(properties.getProperty("mailserver.username"));
		mailSender.setPassword(properties.getProperty("mailserver.password"));
		mailSender.setJavaMailProperties(properties);

		return mailSender;
	}

	@Bean
	public PropertiesFactoryBean properties()
	{
		PropertiesFactoryBean properties = new PropertiesFactoryBean();
		properties.setLocation(new ClassPathResource("mail.properties"));

		return properties;
	}
}
