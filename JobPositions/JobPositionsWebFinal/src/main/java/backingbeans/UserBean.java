package backingbeans;

import interfaces.IUser;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.UserEntity;

@SessionScoped
@Named
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUser iu;

	private String name;
	private String email;
	private String password;
	private String role;

	public void updateUser() {
		UserEntity uent = new UserEntity();
		iu.updateUser(uent);
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
