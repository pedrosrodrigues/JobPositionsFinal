package backingbeans;

import interfaces.IUser;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import services.CandidateImp;
import entities.UserEntity;
import enumeration.RoleEntity;

@SessionScoped
@Named
public class NewUserInputBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	private RoleEntity role;

	@Inject
	private IUser iu;

	public void newUserInput() {
		FacesContext context = FacesContext.getCurrentInstance();
		// log.info("Trying to save a new user (admin created) on database...");
		UserEntity uent = new UserEntity();
		uent.setEmail(this.email);
		uent.setName(this.name);
		uent.setRole(role);
		try {
			uent.setPassword(CandidateImp.passEncript(password));
			// log.info("Password encrypted...");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			iu.saveUser(uent);
			// log.info("New user saved!");
			context.addMessage(null, new FacesMessage("User created!"));
		} catch (Exception e) {
			// log.error("Problem saving user!");
			context.addMessage(null, new FacesMessage(
					"Problem creating the new user!"));
			e.printStackTrace();
		}

	}

}
