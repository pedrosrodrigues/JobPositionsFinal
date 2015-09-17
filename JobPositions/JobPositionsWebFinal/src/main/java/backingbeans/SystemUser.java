package backingbeans;

import interfaces.IUser;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.UserEntity;

@SessionScoped
@Named
public class SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserEntity LoggedUser;
	private boolean logIn;

	@EJB
	private IUser iu;

	public void searchUser(String email) {
		this.LoggedUser = iu.searchUser(email);
		System.out.println(LoggedUser.getRole());
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
		return this.getUserlogado().getName();
	}

}
