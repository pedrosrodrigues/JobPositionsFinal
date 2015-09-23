package backingbeans;

import interfaces.IApplication;
import interfaces.ICandidate;
import interfaces.IJobPosition;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ApplicationEntity;
import entities.CandidateEntity;
import entities.JobEntity;
import enumeration.ApplicationStatus;

@SessionScoped
@Named
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SystemUser su;
	@Inject
	private ICandidate ic;
	@Inject
	private IJobPosition ijp;
	@Inject
	private IApplication ia;

	private CandidateEntity cent;
	private JobEntity jent;
	private int ze;

	private List<ApplicationEntity> listApp = new ArrayList<ApplicationEntity>();;

	private static final Logger log = LoggerFactory
			.getLogger(ApplicationBean.class);

	public void saveApp(int idPosition) {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("trying to save an application on database...");
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();
		System.out.println(idPosition);
		cent = ic.findByEmail(su.getUserlogado().getEmail());
		jent = ijp.findById((long) idPosition);
		System.out.println(cent.getLastname());
		System.out.println(jent.getJobDescription());
		ApplicationEntity aent = new ApplicationEntity();
		aent.setCandidateEntity(cent);
		aent.setJobEntity(jent);
		aent.setAppStatus(ApplicationStatus.OPEN);
		aent.setAplicationDate(dateobj);
		if (ia.saveApplication(aent)) {
			log.info("Application saved on database!");
			context.addMessage(null, new FacesMessage("Application saved!"));

		} else {
			log.error("Application already submited!");
			context.addMessage(
					null,
					new FacesMessage(
							"You have already submitted your application for this job position!"));
		}
	}

	public void start() {
		cent = ic.findByEmail(su.getUserlogado().getEmail());
		listApp = ia.findCandApps(cent.getId());
	}

	public List<ApplicationEntity> getListApp() {
		return listApp;
	}

	public void setListApp(List<ApplicationEntity> listApp) {
		this.listApp = listApp;
	}
}
