package xyz.cicy.mail.sender;

import javax.mail.MessagingException;

public interface EmailSenderService
{
	void send(String text,String filename) throws MessagingException;
}
