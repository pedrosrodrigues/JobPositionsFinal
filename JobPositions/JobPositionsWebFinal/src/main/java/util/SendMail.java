package util;

import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backingbeans.ApplicationBean;

@Named
@RequestScoped
public class SendMail {

	private static final Logger log = LoggerFactory
			.getLogger(ApplicationBean.class);

	public void sendEmail(String subject, String textbody) {
		log.info("Trying to send an email...");

		String from = "jobsatcritical@gmail.com";
		String to = "pedrorodrigues.idl@gmail.com, filipapedrosa@gmail.com";

		final String username = "jobsatcritical@gmail.com";
		final String password = "filipapedro";

		String host = "smtp.gmail.com";
		log.info("Setting properties for email...");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(textbody);
			Transport.send(message);
			log.info("Email sent! ");
		} catch (MessagingException e) {
			log.info("Problem sending email: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}