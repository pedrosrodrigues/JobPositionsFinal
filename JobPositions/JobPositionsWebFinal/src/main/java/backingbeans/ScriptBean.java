package backingbeans;

import interfaces.ICandidate;
import interfaces.IScript;
import interfaces.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ScriptEntity;

@SessionScoped
@Named
public class ScriptBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private IScript ig;

	@Inject
	private IUser iu;

	private String guideName;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private List<ScriptEntity> scriptList = new ArrayList<ScriptEntity>();

	private static final Logger log = LoggerFactory
			.getLogger(ScriptBean.class);

	public void createGuide(){
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to create a new guide on database...");
		ScriptEntity ent = new ScriptEntity();		

		ent.setGuideName(guideName);
		ent.setQuestion1(question1);
		ent.setQuestion2(question2);
		ent.setQuestion3(question3);
		ent.setQuestion4(question4);
		ent.setQuestion5(question5);
		System.out.println("Trying to create a new guide on database...");
		try {
			ig.saveScript(ent);
			log.info("Guide saved on database!");
			context.addMessage(null, new FacesMessage("Guide created!"));
			this.scriptList.add(ent);
			this.guideName= "";
			this.question1= "";
			this.question2= "";
			this.question3= "";
			this.question4 = "";
			this.question5 = "";
		} catch (Exception e) {
			log.error("Problem saving guide!");
			context.addMessage(null, new FacesMessage(
					"Guide creation failed!."));
			e.printStackTrace();
		}
	}

	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	public String getQuestion5() {
		return question5;
	}
	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	public List<ScriptEntity> getScriptList() {
		return scriptList;
	}

	public void setScriptList(List<ScriptEntity> scriptList) {
		this.scriptList = scriptList;
	}
}

