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

import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;

import enumeration.JobStatus;

@Entity
@NamedQueries({
		@NamedQuery(name = "JobEntity.findAll", query = "SELECT j FROM JobEntity j"),
		@NamedQuery(name = "JobEntity.findId", query = "SELECT j FROM JobEntity j WHERE j.id  =:id")})
public class JobEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "JobEntity.findAll";
	public static final String FIND_BY_ID = "JobEntity.findId";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 100)
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 100)
	private Date finalDate;

	@Column(nullable = false, length = 3000, columnDefinition = "text")
	private String jobDescription;

	@Column(nullable = false, length = 100)
	private String company;

	@Column(nullable = false, length = 100)
	private String technicalArea;

	@Column(nullable = false, length = 100)
	private String sla;

	@Column(nullable = false, length = 100)
	private String location;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = true, length = 100)
	private String positionCode;

	@Column(nullable = false, length = 100)
	private String vacancies;

	@ManyToOne
	@JoinColumn(name = "responsable_id", nullable = false)
	private UserEntity responsable;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 100)
	private JobStatus jobStatus;

	@OneToMany(mappedBy = "jobEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ApplicationEntity> applications = new ArrayList<>();;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTechnicalArea() {
		return technicalArea;
	}

	public void setTechnicalArea(String technicalArea) {
		this.technicalArea = technicalArea;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getVacancies() {
		return vacancies;
	}

	public void setVacancies(String vacancies) {
		this.vacancies = vacancies;
	}

	public UserEntity getResponsable() {
		return responsable;
	}

	public void setResponsable(UserEntity responsable) {
		this.responsable = responsable;
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
		JobEntity other = (JobEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<ApplicationEntity> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationEntity> applications) {
		this.applications = applications;
	}
	
	public String toString(){
		return String.format("JobEntity[%d, %s]", id, responsable);
	}

}
