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

import entities.UserEntity;

@SessionScoped
@Named
public class RecoverPassBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private boolean recover = false;
	private String newpass;
	UserEntity user = new UserEntity();

	@Inject
	private IUser iu;

	private static final Logger log = LoggerFactory
			.getLogger(RecoverPassBean.class);

	public void showTable() {
		this.recover = true;
	}

	public void generatePassword() {
		FacesContext context = FacesContext.getCurrentInstance();
		user = iu.searchUser(email);
		if (user.getPassword() != "") {
			user.setPassword("user");
			// iu.updatePass(user);
			context.addMessage(null, new FacesMessage("New password saved!"));

		} else {
			context.addMessage(null, new FacesMessage(
					"That email is not on database!"));
			log.info("Email not on database...");

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
