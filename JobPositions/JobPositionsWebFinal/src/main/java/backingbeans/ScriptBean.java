package backingbeans;

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
public class ScriptBean implements Serializable {

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
	private String expquestion1;
	private String question2;
	private String expquestion2;
	private String question3;
	private String expquestion3;
	private String question4;
	private String expquestion4;
	private String question5;
	private String expquestion5;
	private Long idS;
	private List<ScriptEntity> scriptList = new ArrayList<ScriptEntity>();

	private static final Logger log = LoggerFactory.getLogger(ScriptBean.class);

	@PostConstruct
	public void init() {
		scriptList = is.findAll();
	}

	public ScriptBean() {
		types.add("Formação");
		types.add("Motivação da Candidatura");
		types.add("Percurso Profissional");
	}

	public void addQuestion() {
		questions.clear();
		if ("Formação".equals(type)) {
			questions.add("A");
			questions.add("B");
		} else if ("Motivação da Candidatura".equals(type)) {
			questions.add("C");
			questions.add("D");
		} else if ("Percurso Profissional".equals(type)) {
			questions.add("E");
			questions.add("F");
		}
	}

	public void createScript() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to create a new script on database...");
		ScriptEntity ent = new ScriptEntity();
		ent.setScriptName(scriptName);
		ent.setQuestion1(question1);
		ent.setQuestion2(question2);
		ent.setQuestion3(question3);
		ent.setQuestion4(question4);
		ent.setQuestion5(question5);
		ent.setExpquestion1(expquestion1);
		ent.setExpquestion2(expquestion2);
		ent.setExpquestion3(expquestion3);
		ent.setExpquestion4(expquestion4);
		ent.setExpquestion5(expquestion5);
		try {
			is.saveScript(ent);
			clear();
			log.info("Script saved on database!");
			context.addMessage(null, new FacesMessage("Script created!"));
			this.scriptList.add(ent);

		} catch (Exception e) {
			log.error("Problem saving guide!");
			context.addMessage(
					null,
					new FacesMessage(
							"Script creation failed!There´s already a script with this name."));
			e.printStackTrace();
		}
	}

	public void clear() {
		this.scriptName = "";
		this.question1 = " ";
		this.question2 = " ";
		this.question3 = " ";
		this.question4 = " ";
		this.question5 = " ";
		this.expquestion1 = "";
		this.expquestion2 = "";
		this.expquestion3 = "";
		this.expquestion4 = "";
		this.expquestion5 = "";
	}

	public void infoScript(Long id) {
		ScriptEntity ent = new ScriptEntity();
		this.idS = id;
		ent = is.findById(id);
		setScriptName(ent.getScriptName());
		setQuestion1(ent.getQuestion1());
		setQuestion2(ent.getQuestion2());
		setQuestion3(ent.getQuestion3());
		setQuestion4(ent.getQuestion4());
		setQuestion5(ent.getQuestion5());
		setExpquestion1(ent.getExpquestion1());
		setExpquestion2(ent.getExpquestion2());
		setExpquestion3(ent.getExpquestion3());
		setExpquestion4(ent.getExpquestion4());
		setExpquestion5(ent.getExpquestion5());
	}

	public void updateScript() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to update a script on database...");
		ScriptEntity ent = new ScriptEntity();
		ent.setScriptName(this.scriptName);
		ent.setQuestion1(this.question1);
		ent.setQuestion2(this.question2);
		ent.setQuestion3(this.question3);
		ent.setQuestion4(this.question4);
		ent.setQuestion5(this.question5);
		ent.setExpquestion1(this.expquestion1);
		ent.setExpquestion2(this.expquestion2);
		ent.setExpquestion3(this.expquestion3);
		ent.setExpquestion4(this.expquestion4);
		ent.setExpquestion5(this.expquestion5);
		ent.setId(this.idS);
		try {
			is.updateScript(ent);
			clear();
			init();
			log.info("Script updated on database!");
			context.addMessage(null, new FacesMessage(
					"Script updated on database!"));
		} catch (Exception e) {
			log.error("Problem updating script!");
			context.addMessage(null, new FacesMessage(
					"Problem updating script!"));
			e.printStackTrace();
		}
	}

	public void deleteScript(Long id) {
		System.out.println("a entrar no metodo deleteScript");
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to delete a script...");
		ScriptEntity ent = new ScriptEntity();
		ent = is.findById(id);
		try {
			is.remove(ent);
			this.scriptList.remove(ent);
			log.info("Script deleted on database!");
			context.addMessage(null, new FacesMessage("Script deleted!"));
		} catch (Exception e) {
			log.error("Problem deleting script!");
			context.addMessage(null, new FacesMessage("Operation failed!"));
			e.printStackTrace();
		}
	}

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

	public String getExpquestion1() {
		return expquestion1;
	}

	public void setExpquestion1(String expquestion1) {
		this.expquestion1 = expquestion1;
	}

	public String getExpquestion2() {
		return expquestion2;
	}

	public void setExpquestion2(String expquestion2) {
		this.expquestion2 = expquestion2;
	}

	public String getExpquestion3() {
		return expquestion3;
	}

	public void setExpquestion3(String expquestion3) {
		this.expquestion3 = expquestion3;
	}

	public String getExpquestion4() {
		return expquestion4;
	}

	public void setExpquestion4(String expquestion4) {
		this.expquestion4 = expquestion4;
	}

	public String getExpquestion5() {
		return expquestion5;
	}

	public void setExpquestion5(String expquestion5) {
		this.expquestion5 = expquestion5;
	}

	public Long getIdS() {
		return idS;
	}

	public void setIdS(Long idS) {
		this.idS = idS;
	}

}
