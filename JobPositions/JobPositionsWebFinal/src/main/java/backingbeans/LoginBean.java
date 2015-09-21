package backingbeans;

import interfaces.ICandidate;
import interfaces.IJobPosition;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.CandidateEntity;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private CandidateEntity ce;

	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);

	@Inject
	private SystemUser su;

	@Inject
	private ICandidate ic;

	@Inject
	private CandidateBean cb;

	@Inject
	private JobPositionBean jpb;

	@Inject
	private IJobPosition ij;

	public String login() throws NoSuchAlgorithmException,
			UnsupportedEncodingException, ParseException {
		log.info("Attempt to login...");
		String page = "";
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();

		try {
			request.login(email, password);

		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage(
					"Login failed! User not on database."));
			log.error("Login failed!");
			return "LoginError.xhtml?faces-redirect=true";
		}
		su.searchUser(email);
		su.setLogIn(true);
		String role = su.getUserlogado().getRole().toString();
		if (role.equals("ADMINISTRATOR"))
			page = "/admin/AdminPage.xhtml?faces-redirect=true";
		else if (role.equals("MANAGER"))
			page = "/manager/ManagerPage.xhtml?faces-redirect=true";
		else if (role.equals("INTERVIEWER"))
			page = "/interviewer/InterviewerPage.xhtml?faces-redirect=true";
		else if (role.equals("CANDIDATE")) {
			setCandidateInfo();
			page = "/simpleuser/UserPage.xhtml?faces-redirect=true";
		}
		log.info("Login sucessfull!");
		context.addMessage(null, new FacesMessage("Login sucessfull!"));
		jpb.setJobpositions(ij.findAll());
		return page;
	}

	private void setCandidateInfo() {
		log.info("Setting candidate information!");
		ce = ic.findByEmail(su.getUserlogado().getEmail());
		if (ce != null) {
			cb.setAddress(ce.getAddress());
			cb.setCity(ce.getCity());
			cb.setCountry(ce.getCountry());
			cb.setCourse(ce.getCourse());
			cb.setFirstname(ce.getFirstname());
			cb.setLastname(ce.getLastname());
			cb.setLinkedin(ce.getLinkedin());
			cb.setMobile(ce.getMobile());
			cb.setPassword(ce.getPassword());
			cb.setPhone(ce.getPhone());
			cb.setSchool(ce.getSchool());
		}
	}

	public void logout() {
		log.info("logout attempt...");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		try {
			request.logout();
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/Home.xhtml");
			su.setUserlogado(null);
			su.setLogIn(false);
			context.addMessage(null, new FacesMessage("Logout sucessfull!."));
			log.info("Logout sucessfull!");
		} catch (ServletException e) {
			log.error("Logout failure!");
			context.addMessage(null, new FacesMessage("Logout failed."));
		} catch (IOException e) {
			log.error("Redirect failure!");
			context.addMessage(
					null,
					new FacesMessage(
							"Logout sucessfull! Redirecting to home page failed by some reason."));
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
