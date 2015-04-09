package org.domain.avaluosapl.util;

import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private static Email instance;
	private final String username;
	private final String password;
	private Session session;
	
	private Email(String user, String pass) {
		username = user;
		password = pass;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	}
	
	public static Email getInstance () {
		if (instance == null) {
			instance = new Email("pqrweb@cosmitet.net", "C0sm1t3t");
		}
		return instance;
	}
	
	public void send(String subject, String maildestino, String msjenviar){
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(maildestino));
			message.setSubject(subject);
			message.setText(msjenviar);
			Transport.send(message); 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
