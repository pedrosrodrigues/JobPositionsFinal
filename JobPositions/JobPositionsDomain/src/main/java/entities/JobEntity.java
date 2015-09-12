package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumeration.JobStatus;

@Entity
public class JobEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date creationDate;
	private Date finalDate;
	private String jobDescription;
	private String company;
	private String technicalArea;
	private String sla;
	private String location;
	private String title;
	private String positionCode;
	private JobStatus jobStatus;
	//private List<CandidateEntity> candidates = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	@Column(nullable = false, length=200)
	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	@Column(nullable = false, length=20)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(nullable = false, length=50)
	public String getTechnicalArea() {
		return technicalArea;
	}

	public void setTechnicalArea(String technicalArea) {
		this.technicalArea = technicalArea;
	}

	@Column(nullable = false, length=20)
	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	@Column(nullable = false, length=50)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(nullable = false, length=50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false, length=20)
	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length=20)
	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

//	public List<CandidateEntity> getCandidates() {
//		return candidates;
//	}
//
//	public void setCandidates(List<CandidateEntity> candidates) {
//		this.candidates = candidates;
//	}

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
		JobEntity other = (JobEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
