package backingbeans;

import interfaces.IUser;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.UserEntity;

@SessionScoped
@Named
public class SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserEntity LoggedUser;
	private boolean logIn;

	private static final Logger log = LoggerFactory.getLogger(SystemUser.class);

	@EJB
	private IUser iu;

	public void searchUser(String email) {
		log.info("Finding user on database...");
		log.info("Setting logged user...");
		this.LoggedUser = iu.searchUser(email);
	}

	public boolean isLogIn() {
		return logIn;
	}

	public void setLogIn(boolean logIn) {
		this.logIn = logIn;
	}

	public UserEntity getUserlogado() {
		return LoggedUser;
	}

	public void setUserlogado(UserEntity userlogado) {
		this.LoggedUser = userlogado;
	}

	public String getLoggedUserName() {
		if (this.LoggedUser == null) {
			this.LoggedUser = new UserEntity();
		}
		return this.getUserlogado().getName();
	}

}
