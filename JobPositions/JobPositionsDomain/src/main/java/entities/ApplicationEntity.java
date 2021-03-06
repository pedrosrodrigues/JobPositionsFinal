package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumeration.ApplicationStatus;

@Entity
@NamedQueries({
		@NamedQuery(name = "ApplicationEntity.findOne", query = "SELECT a FROM ApplicationEntity a WHERE a.jobEntity.id=:idJob and a.candidateEntity.id=:idCan"),
		@NamedQuery(name = "ApplicationEntity.findCandApp", query = "SELECT a FROM ApplicationEntity a WHERE a.candidateEntity.id=:idCan"),
		@NamedQuery(name = "ApplicationEntity.findJobCand", query = "SELECT a FROM ApplicationEntity a WHERE a.jobEntity.id=:idJob"),
		@NamedQuery(name = "ApplicationEntity.findById", query = "SELECT a FROM ApplicationEntity a WHERE a.id=:id"),
		@NamedQuery(name = "ApplicationEntity.findGenAppCand", query = "SELECT a FROM ApplicationEntity a WHERE a.jobEntity.title=:title") })
public class ApplicationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_CANJOB = "ApplicationEntity.findOne";
	public static final String FIND_BY_CANDAPP = "ApplicationEntity.findCandApp";
	public static final String FIND_BY_JOBCAND = "ApplicationEntity.findJobCand";
	public static final String FIND_BY_ID = "ApplicationEntity.findById";

	public static final String FIND_GEN_APP_CAND = "ApplicationEntity.findGenAppCand";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 100)
	private Date aplicationDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 100)
	private ApplicationStatus appStatus;

	@ManyToOne
	@JoinColumn(name = "candidate_id", nullable = false)
	private CandidateEntity candidateEntity;

	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<InterviewEntity> intList = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private JobEntity jobEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAplicationDate() {
		return aplicationDate;
	}

	public void setAplicationDate(Date aplicationDate) {
		this.aplicationDate = aplicationDate;
	}

	public CandidateEntity getCandidateEntity() {
		return candidateEntity;
	}

	public void setCandidateEntity(CandidateEntity candidateEntity) {
		this.candidateEntity = candidateEntity;
	}

	public JobEntity getJobEntity() {
		return jobEntity;
	}

	public void setJobEntity(JobEntity jobEntity) {
		this.jobEntity = jobEntity;
	}

	public ApplicationStatus getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(ApplicationStatus appStatus) {
		this.appStatus = appStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationEntity other = (ApplicationEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
