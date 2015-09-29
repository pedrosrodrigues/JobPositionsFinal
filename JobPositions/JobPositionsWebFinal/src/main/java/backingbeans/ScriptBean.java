package backingbeans;

import interfaces.ICandidate;
import interfaces.IScript;
import interfaces.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	private IScript is;

	@Inject
	private IUser iu;

	private String scriptName;
	private String type;
	private String question;
	private List<String> types = new ArrayList<>();
	private List<String> questions = new ArrayList<>();
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private List<ScriptEntity> scriptList = new ArrayList<ScriptEntity>();

	private static final Logger log = LoggerFactory
			.getLogger(ScriptBean.class);

	@PostConstruct
	public void init() {
		scriptList = is.findAll();
	}
	
	public ScriptBean() {
		types.add("Formação");
		types.add("Motivação da Candidatura");
		types.add("Percurso Profissional");
	}

	public void addQuestion(){
		questions.clear();
		if ("Formação".equals(type)){
			questions.add("A");
			questions.add("B");		
		} else if ("Motivação da Candidatura".equals(type)){
			questions.add("C");
			questions.add("D");		
		}else if ("Percurso Profissional".equals(type)){
			questions.add("E");
			questions.add("F");			
		}
	}


	public void createScript(){
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to create a new guide on database...");
		ScriptEntity ent = new ScriptEntity();		
		ent.setScriptName(scriptName);
		ent.setQuestion1(question1);
		ent.setQuestion2(question2);
		ent.setQuestion3(question3);
		ent.setQuestion4(question4);
		ent.setQuestion5(question5);
		System.out.println("Trying to create a new guide on database...");
		try {
			is.saveScript(ent);
			log.info("Guide saved on database!");
			context.addMessage(null, new FacesMessage("Guide created!"));
			this.scriptList.add(ent);
			this.scriptName= null;
			this.question1= null;
			this.question2= null;
			this.question3= null;
			this.question4 = null;
			this.question5 = null;
		} catch (Exception e) {
			log.error("Problem saving guide!");
			context.addMessage(null, new FacesMessage(
					"Script creation failed!There´s already a script with this name."));
			e.printStackTrace();
		}
	}
//	
//	public void loadsriptlist(){
//		System.out.println("a tentar imprimir script list");
//		scriptList = is.findAll();
//		System.out.println(this.scriptList);
//	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public List<String> getTypes() {
		return types;
	}


	public void setTypes(List<String> types) {
		this.types = types;
	}


	public List<String> getQuestions() {
		return questions;
	}


	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}


}

