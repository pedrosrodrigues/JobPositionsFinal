package backingbeans;

import interfaces.IUser;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.SendMail;
import entities.UserEntity;

@SessionScoped
@Named
public class RecoverPassBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private boolean recover = false;

	@Inject
	private IUser iu;
	@Inject
	private SendMail emailSender;

	private static final Logger log = LoggerFactory
			.getLogger(RecoverPassBean.class);

	public void showTable() {
		this.recover = true;
	}

	public void generatePassword() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			UserEntity user = iu.searchUser(email);
			System.out.println(email);
			user.setPassword("user");
			iu.updatePass(user);
			context.addMessage(
					null,
					new FacesMessage(
							"New password saved on database, an email was sent to your email!"));
			log.info("New password generated.");
			emailSender
					.sendEmail(
							"Pedido de recuperação de password. ",
							"Muito boa tarde Sr(a) "
									+ user.getName()
									+ ",\n\nServe o presente e-mail para o informar que a sua nova password é: user "
									+ "\n\nPode fazer o login normalmente na nossa plataforma.\n\nOs nossos melhores cumprimentos,\njobsatcritical@gmail.com");
			log.info("Email sent to email.");
			this.email = "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					"That email is not on database!"));
			log.info("Email not on database!");
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRecover() {
		return recover;
	}

	public void setRecover(boolean recover) {
		this.recover = recover;
	}

}
