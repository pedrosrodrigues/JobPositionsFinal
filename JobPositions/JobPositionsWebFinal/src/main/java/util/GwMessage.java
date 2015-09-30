package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class GwMessage
 */
public class GwMessage {

	public static void main(String[] args) {
		final String username = "jobsatcritical@gmail.com";
		final String password = "filipapedro";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"jobsatcritical@gmail.com", "filipapedro");
					}

				});
		System.out.println("meteu props.");

		try {
			System.out.println("entrou no mime");
			MimeMessage msg = new MimeMessage(session);
			System.out.println("passou o mime");
			msg.setFrom(username);
			msg.setRecipients(Message.RecipientType.TO,
					"pedrorodrigues.idl@gmail.com");
			msg.setSubject("JavaMail hello world example");
			msg.setSentDate(new Date());
			msg.setText("Hello, world!\n");
			System.out.println("fez os sets");
			Transport.send(msg);
			System.out.println("Email enviado.");
		} catch (MessagingException mex) {
			System.out.println("send failed, exception: " + mex);
		}

	}
}