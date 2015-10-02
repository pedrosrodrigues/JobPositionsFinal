package backingbeans;

import interfaces.IApplication;
import interfaces.IInterview;
import interfaces.IScript;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ApplicationEntity;
import entities.InterviewEntity;
import entities.ScriptEntity;
import entities.UserEntity;

@SessionScoped
@Named
public class InterviewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SystemUser su;

	@Inject
	private IInterview ii;

	@Inject
	private IUser iu;

	@Inject
	private IScript is;

	@Inject
	private IApplication ia;

	private InterviewEntity currentInt;
	private ApplicationEntity currentApp;
	private Date interviewDate;
	private ScriptEntity script;
	private UserEntity interviewer;
	private ApplicationEntity application;
	private String scriptName;
	private String interviewerEmail;
	private Long idApplication;
	private List<InterviewEntity> myInterviews = new ArrayList<InterviewEntity>();
	private List<InterviewEntity> allInterviews = new ArrayList<InterviewEntity>();
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private String feedback;
	private Long IntId;

	private static final Logger log = LoggerFactory
			.getLogger(InterviewBean.class);

	@PostConstruct
	public void init() {
		myInterviews = ii.findMyInterviews(su.getUserlogado().getId());
	}

	public void createInterview() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to save a new interview on database...");
		InterviewEntity ient = new InterviewEntity();
		ient.setSubmitted(false);
		ient.setInterviewDate(interviewDate);
		ient.setInterviewer(iu.searchUser(interviewerEmail));
		ient.setScript(is.findByName(scriptName));
		ient.setApplication(ia.findById(idApplication));
		try {
			ii.saveInterview(ient);
			log.info("Interview saved on database!");
			context.addMessage(null, new FacesMessage(
					"Interview saved on database!"));
		} catch (Exception e) {
			log.error("Problem creating a new interview!");
			context.addMessage(null, new FacesMessage(
					"There was a problem appointing the interview!"));
		}
	}

	public void searchInterviewResults(Long idApp) {
		this.currentApp = ia.findById(idApp);
		allInterviews = ii.findAll();
		for (InterviewEntity inter : allInterviews) {
			if (inter.getApplication().getId() == idApp && inter.isSubmitted()) {
				System.out.println("Nome:"
						+ inter.getApplication().getCandidateEntity()
								.getFirstname());
				this.currentInt = inter;
			}
		}
	}

	public void updateInterview() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to update a interview on database...");
		InterviewEntity ient = new InterviewEntity();
		ient.setId(this.IntId);
		ient.setAnswer1(this.answer1);
		ient.setAnswer2(this.answer2);
		ient.setAnswer3(this.answer3);
		ient.setAnswer4(this.answer4);
		ient.setAnswer5(this.answer5);
		ient.setFeedback(this.feedback);
		ient.setSubmitted(true);
		try {
			ii.updateInterview(ient);
			log.info("Interview saved on database!");
			context.addMessage(null, new FacesMessage(
					"Interview saved on database!"));
		} catch (Exception e) {
			log.error("Problem creating a new interview!");
			context.addMessage(null, new FacesMessage(
					"There was a problem appointing the interview!"));
		}
	}

	private void clear() {
		setAnswer1("");
		setAnswer2("");
		setAnswer3("");
		setAnswer4("");
		setAnswer5("");
		setFeedback("");
	}

	public void searchInterview(Long idInt) {
		this.currentInt = ii.findIntById(idInt);
		this.IntId = idInt;
	}

	public void start() {
		myInterviews = ii.findMyInterviews(su.getUserlogado().getId());

	}

	public boolean checkInterview(Long idApp) {
		allInterviews = ii.findAll();
		for (InterviewEntity inter : allInterviews) {
			if (inter.getApplication().getId() == idApp && inter.isSubmitted()) {
				return true;
			}
		}
		return false;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public UserEntity getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(UserEntity interviewer) {
		this.interviewer = interviewer;
	}

	public ScriptEntity getScript() {
		return script;
	}

	public void setScript(ScriptEntity script) {
		this.script = script;
	}

	public ApplicationEntity getApplication() {
		return application;
	}

	public void setApplication(ApplicationEntity application) {
		this.application = application;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getInterviewerEmail() {
		return interviewerEmail;
	}

	public void setInterviewerEmail(String interviewerEmail) {
		this.interviewerEmail = interviewerEmail;
	}

	public Long getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
	}

	public List<InterviewEntity> getMyInterviews() {
		return myInterviews;
	}

	public void setMyInterviews(List<InterviewEntity> myInterviews) {
		this.myInterviews = myInterviews;
	}

	public List<InterviewEntity> getAllInterviews() {
		return allInterviews;
	}

	public void setAllInterviews(List<InterviewEntity> allInterviews) {
		this.allInterviews = allInterviews;
	}

	public ApplicationEntity getCurrentApp() {
		return currentApp;
	}

	public void setCurrentApp(ApplicationEntity currentApp) {
		this.currentApp = currentApp;
	}

	public InterviewEntity getCurrentInt() {
		return currentInt;
	}

	public void setCurrentInt(InterviewEntity currentInt) {
		this.currentInt = currentInt;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Long getIntId() {
		return IntId;
	}

	public void setIntId(Long intId) {
		IntId = intId;
	}

}
