package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ApplicationEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date aplicationDate;
	private CandidateEntity candidateEntity;
	private JobEntity jobEntity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 100)
	public Date getAplicationDate() {
		return aplicationDate;
	}
	
	public void setAplicationDate(Date aplicationDate) {
		this.aplicationDate = aplicationDate;
	}
	
	@Column(nullable = false, length = 100)
	public CandidateEntity getCandidateEntity() {
		return candidateEntity;
	}
	
	public void setCandidateEntity(CandidateEntity candidateEntity) {
		this.candidateEntity = candidateEntity;
	}
	
	@Column(nullable = false, length = 100)
	public JobEntity getJobEntity() {
		return jobEntity;
	}
	
	public void setJobEntity(JobEntity jobEntity) {
		this.jobEntity = jobEntity;
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
