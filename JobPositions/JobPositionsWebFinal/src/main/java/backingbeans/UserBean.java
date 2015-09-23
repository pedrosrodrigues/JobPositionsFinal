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
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUser iu;
	@Inject
	private SystemUser su;

	private String name;
	private String email;
	private String password;
	private String role;

	private static final Logger log = LoggerFactory.getLogger(UserBean.class);

	public void updateUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Updating user...");
		UserEntity uent = new UserEntity();
		uent.setEmail(this.email);
		uent.setName(this.name);
		uent.setPassword(this.password);
		try {
			iu.updateUser(uent);
			log.info("User updated!");
			context.addMessage(null, new FacesMessage("User updated!"));
		} catch (Exception e) {
			log.info("Problem updating user!");
			context.addMessage(null, new FacesMessage("Problem upating user!"));
			e.printStackTrace();
		}
		su.searchUser(email);
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
