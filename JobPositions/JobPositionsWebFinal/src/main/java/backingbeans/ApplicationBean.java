package backingbeans;

import interfaces.IApplication;
import interfaces.ICandidate;
import interfaces.IJobPosition;
import interfaces.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ApplicationEntity;
import entities.CandidateEntity;
import entities.JobEntity;
import entities.UserEntity;
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
	@Inject
	private IUser iu;

	private CandidateEntity cent;
	private JobEntity jent;

	private ApplicationStatus appStatus;

	private List<ApplicationEntity> listApp = new ArrayList<ApplicationEntity>();
	private List<ApplicationEntity> listPosApp = new ArrayList<ApplicationEntity>();
	private List<UserEntity> interviewerList = new ArrayList<UserEntity>();
	private String interviewerEmail;

	private static final Logger log = LoggerFactory
			.getLogger(ApplicationBean.class);

	public void saveApp(int idPosition) {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("trying to save an application on database...");
		Date dateobj = new Date();
		cent = ic.findByEmail(su.getUserlogado().getEmail());
		jent = ijp.findById((long) idPosition);
		ApplicationEntity aent = new ApplicationEntity();
		aent.setCandidateEntity(cent);
		aent.setJobEntity(jent);
		aent.setAppStatus(ApplicationStatus.SUBMITTED);
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

	public void updateApp(Long idApplication) {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to update an application on database...");
		ApplicationEntity aent = new ApplicationEntity();
		for (ApplicationEntity x : listPosApp) {
			if (x.getId() == idApplication) {
				this.appStatus = x.getAppStatus();
			}
		}
		aent.setAppStatus(appStatus);
		aent.setId(idApplication);
		try {
			ia.updateApplication(aent);
			log.info("Application updated!");
			context.addMessage(null, new FacesMessage("Application updated!"));
		} catch (Exception e) {
			log.info("Problem updating application!");
			context.addMessage(null, new FacesMessage(
					"Problem upating application!"));
			e.printStackTrace();
		}
		// despoletar caixa de entrevista
		if (this.appStatus.equals(ApplicationStatus.INTERVIEWING)) {
			RequestContext cont = RequestContext.getCurrentInstance();
			cont.execute("PF('InterviewDialog').show();");
		}
	}

	@PostConstruct
	public void init() {
		interviewerList = iu.findAllInterviewers();
	}

	public void start() {
		cent = ic.findByEmail(su.getUserlogado().getEmail());
		listApp = ia.findCandApps(cent.getId());
	}

	public void searchCandidates(Long idPos) {
		listPosApp = ia.findByJobCand(idPos);
	}

	public List<ApplicationEntity> getListApp() {
		return listApp;
	}

	public void setListApp(List<ApplicationEntity> listApp) {
		this.listApp = listApp;
	}

	public List<ApplicationEntity> getListPosApp() {
		return listPosApp;
	}

	public void setListPosApp(List<ApplicationEntity> listPosApp) {
		this.listPosApp = listPosApp;
	}

	public ApplicationStatus getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(ApplicationStatus appStatus) {
		this.appStatus = appStatus;
	}

	public List<UserEntity> getInterviewerList() {
		return interviewerList;
	}

	public void setInterviewerList(List<UserEntity> interviewerList) {
		this.interviewerList = interviewerList;
	}

	public String getInterviewerEmail() {
		return interviewerEmail;
	}

	public void setInterviewerEmail(String interviewerEmail) {
		this.interviewerEmail = interviewerEmail;
	}

}
