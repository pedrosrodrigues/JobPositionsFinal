package backingbeans;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			return "LoginError.xhtml?faces-redirect=true";
		}
		return "/simpleuser/UserPage.xhtml?faces-redirect=true";
	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		try {
			request.logout();
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/Home.xhtml");
		} catch (ServletException e) {
			// log.error("Logout failure");
			// context.addMessage(null, new FacesMessage("Logout falhou."));
		} catch (IOException e) {
			// log.error("Redirect failure");
			// context.addMessage(null, new FacesMessage("Logout falhou."));
		}
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
}
