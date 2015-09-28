package backingbeans;

import interfaces.ICandidate;
import interfaces.IGuide;

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

import entities.CandidateEntity;
import entities.GuideEntity;

@SessionScoped
@Named
public class GuideBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private IGuide ig;
	@Inject
	private SystemUser su;
	@Inject
	private ICandidate ic;

	private String guideName;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private CandidateEntity cent;
	private List<GuideEntity> guidesList = new ArrayList<GuideEntity>();

	private static final Logger log = LoggerFactory
			.getLogger(GuideBean.class);

	public void createGuide(){
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to create a new guide on database...");
		GuideEntity ent = new GuideEntity();		

		ent.setGuideName(guideName);
		ent.setQuestion1(question1);
		ent.setQuestion2(question2);
		ent.setQuestion3(question3);
		ent.setQuestion4(question4);
		ent.setQuestion5(question5);
		
		System.out.println("Trying to create a new guide on database...");
		try {
			ig.saveGuide(ent);
			log.info("Guide saved on database!");
			context.addMessage(null, new FacesMessage("Guide created!"));
			this.guidesList.add(ent);
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

		public List<GuideEntity> getGuidesList() {
			return guidesList;
		}

		public void setGuidesList(List<GuideEntity> guidesList) {
			this.guidesList = guidesList;
		}



	}

