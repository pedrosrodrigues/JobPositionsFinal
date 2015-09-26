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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger log = LoggerFactory
			.getLogger(NewUserInputBean.class);

	@Inject
	private IUser iu;

	public void newUserInput() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to save a new user (admin created) on database...");
		UserEntity uent = new UserEntity();
		uent.setEmail(this.email);
		uent.setName(this.name);
		uent.setRole(role);
		try {
			uent.setPassword(CandidateImp.passEncript(password));
			log.info("Password encrypted!");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error("Problem encrypting password!");
			e.printStackTrace();
		}

		try {
			iu.saveUser(uent);
			this.email = "";
			this.name = "";
			this.password = "";
			log.info("New user saved!");
			context.addMessage(null, new FacesMessage("User created!"));
		} catch (Exception e) {
			log.error("Problem saving user!");
			context.addMessage(null, new FacesMessage(
					"Problem creating the new user! Email already existed!"));
			e.printStackTrace();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

}
