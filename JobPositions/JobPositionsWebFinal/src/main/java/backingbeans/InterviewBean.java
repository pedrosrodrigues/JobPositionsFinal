package backingbeans;

import interfaces.IApplication;
import interfaces.IInterview;
import interfaces.IScript;
import interfaces.IUser;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
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
public class InterviewBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private IInterview ii;
	
	@Inject
	private IUser iu;
	
	@Inject
	private IScript is;
	
	@Inject
	private IApplication ia;
	
	private Date interviewDate;
	private ScriptEntity script;
	private UserEntity interviewer;
	private ApplicationEntity application;	
	private String scriptName;
	private String interviewerEmail;

	private static final Logger log = LoggerFactory
			.getLogger(InterviewBean.class);
	
	public void createInterview(int id) {
		System.out.println("createInterview");
//		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to save a new interview on database...");
		application = ia.findById((long) id);
		script = is.findByName(scriptName);
		InterviewEntity ent = new InterviewEntity ();
		ent.setInterviewDate(interviewDate);
		ent.setInterviewer(iu.searchUser(interviewerEmail));
		ent.setScript(script);
		ii.saveInterview(ent);		
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

	
	
}
