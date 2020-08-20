package Modele;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	final String username = ""; //useranme
	final String password = ""; //password
	final String frommail = ""; // email
	String subject;
	String textmessage;

	public void initMessageTypeConfiramation(int code) {
		subject="Code de confirmation";
		textmessage= "<div align=\"center\">\r\n" + 
				"<h1>BelAirClub</h1>\r\n" + 
				"<h2>code de confirmation</h2>\r\n" + 
				"<h3>"+code+"<h3>\r\n" + 
				"</div>";

	}
	public void initMessageTypeAnnulationCreneaux(int code,int jour,int heure) {
		subject="Creneax est Annuler";
		textmessage= "<div align=\"center\">\r\n" + 
				"<h1>BelAirClub</h1>\r\n" + 
				"<h2>le creneaux suivant est annuler Bienvunue</h2>\r\n" + 
				"<h3>Code "+code+" jour "+jour +" heure "+heure+"<h3>\r\n" + 
				"</div>";

	}
	public void sendCode(int code,String email) {
		
		Properties Properties = new Properties();
		Properties.put("mail.smtp.auth", "true");
		Properties.put("mail.smtp.starttls.enable", "true");
		Properties.put("mail.smtp.host", "smtp.gmail.com");
		Properties.put("mail.smtp.port", "587");
		initMessageTypeConfiramation(code);
		Session session = Session.getDefaultInstance(Properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(frommail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));	
			message.setSubject(subject);
			message.setContent(textmessage,"text/html");
			Transport.send(message);
			
			
			
		}
		catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public void sendAnnulation(String email,int code,int jour,int heure) {
		Properties Properties = new Properties();
		Properties.put("mail.smtp.auth", "true");
		Properties.put("mail.smtp.starttls.enable", "true");
		Properties.put("mail.smtp.host", "smtp.gmail.com");
		Properties.put("mail.smtp.port", "587");
		initMessageTypeAnnulationCreneaux(code,jour,heure);
		Session session = Session.getDefaultInstance(Properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(frommail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
			message.setSubject(subject);
			message.setContent(textmessage,"text/html");
			Transport.send(message);
			
			
			
		}
		catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
}
	

