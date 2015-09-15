package backingbeans;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	public String login() throws NoSuchAlgorithmException,
			UnsupportedEncodingException, ParseException {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.login(email, password);
		} catch (ServletException e) {
			return "LoginError.xhtml";
		}
		return "/simpleuser/UserPage.xhtml";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.logout();
			return "Home.xhtml?faces-redirect=true";
		} catch (ServletException e) {
			return "/simpleuser/UserPage.xhtml";
		}
	}
}
