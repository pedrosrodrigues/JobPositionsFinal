package backingbeans;

import interfaces.ICandidate;
import interfaces.IUser;

import java.io.File;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.UploadFile;
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
	@Inject
	private ICandidate ic;

	public void searchUser(String email) {
		log.info("Finding user on database...");
		log.info("Setting logged user...");
		this.LoggedUser = iu.searchUser(email);
	}

	public String cvPath(String email) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + "/userCV/"
				+ iu.searchUser(email).getId()
				+ ic.findByEmail(email).getFirstname()
				+ ic.findByEmail(email).getLastname() + "CV"
				+ UploadFile.DOCUMENT_EXTENSION_PDF;
	}

	public String mlPath(String email) {
		// (.pdf)
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + "/userCV/"
				+ iu.searchUser(email).getId()
				+ ic.findByEmail(email).getFirstname()
				+ ic.findByEmail(email).getLastname() + "ML"
				+ UploadFile.DOCUMENT_EXTENSION_PDF;
	}

	public boolean cvFileExists(String email) {
		// path Filipa: -> copy disto
		// "c://Users/Filipa Pedrosa/Desktop/JAVA/PROGRAMAS/wildfly-8.2.0.Final/bin/userCV/"
		// path Pedro: -> copy disto
		// "c://Users/peter/wildfly-8.0.0.Final/bin/userCV/"

		boolean exists = new File(
				"c://Users/peter/wildfly-8.0.0.Final/bin/userCV/"
						+ iu.searchUser(email).getId()
						+ ic.findByEmail(email).getFirstname()
						+ ic.findByEmail(email).getLastname() + "CV"
						+ UploadFile.DOCUMENT_EXTENSION_PDF).exists();
		return exists;
	}

	public boolean mlFileExists(String email) {
		boolean exists = new File(
				"c://Users/peter/wildfly-8.0.0.Final/bin/userCV/"
						+ iu.searchUser(email).getId()
						+ ic.findByEmail(email).getFirstname()
						+ ic.findByEmail(email).getLastname() + "ML"
						+ UploadFile.DOCUMENT_EXTENSION_PDF).exists();
		return exists;
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
