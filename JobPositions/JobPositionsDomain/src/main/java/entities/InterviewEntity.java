package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "InterviewEntity.findById", query = "SELECT i FROM InterviewEntity i WHERE i.interviewer.id=:id"),
		@NamedQuery(name = "InterviewEntity.findAll", query = "SELECT i FROM InterviewEntity i"),
		@NamedQuery(name = "InterviewEntity.findByIdInt", query = "SELECT i FROM InterviewEntity i WHERE i.id=:id") })
public class InterviewEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_ID = "InterviewEntity.findById";
	public static final String FIND_ALL = "InterviewEntity.findAll";
	public static final String FIND_BY_ID_INT = "InterviewEntity.findByIdInt";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, length = 100)
	private Date interviewDate;

	@ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	private ApplicationEntity application;

	@ManyToOne
	@JoinColumn(name = "interviewer_id", nullable = false)
	private UserEntity interviewer;

	@ManyToOne
	@JoinColumn(name = "script_id", nullable = false)
	private ScriptEntity script;

	@Column(nullable = false, length = 100)
	private boolean submitted;

	@Column(nullable = true, length = 100)
	private String answer1;

	@Column(nullable = true, length = 100)
	private String answer2;

	@Column(nullable = true, length = 100)
	private String answer3;

	@Column(nullable = true, length = 100)
	private String answer4;

	@Column(nullable = true, length = 100)
	private String answer5;

	@Column(nullable = true, length = 100)
	private String feedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public ApplicationEntity getApplication() {
		return application;
	}

	public void setApplication(ApplicationEntity application) {
		this.application = application;
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

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
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

}
