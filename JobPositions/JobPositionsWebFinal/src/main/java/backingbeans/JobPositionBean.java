package backingbeans;

import interfaces.IJobPosition;
import interfaces.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.JobEntity;
import entities.UserEntity;
import enumeration.JobStatus;

@SessionScoped
@Named
public class JobPositionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IJobPosition ij;

	@Inject
	private IUser iu;

	private Date creationDate;
	private Date finalDate;
	private String jobDescription;
	private String company;
	private String technicalArea;
	private String sla;
	private String location;
	private String title;
	private String positionCode;
	private String responsableEmail;
	private String vacancies;
	private JobStatus jobStatus;
	private UserEntity responsable;
	private String selectPosition;
	private List<JobEntity> jobpositions = new ArrayList<JobEntity>();
	private List<JobEntity> jobpositionsfilter = new ArrayList<JobEntity>();
	private List<UserEntity> responsableList = new ArrayList<UserEntity>();
	private Long idJob;

	private static final Logger log = LoggerFactory
			.getLogger(JobPositionBean.class);

	@PostConstruct
	public void init() {
		responsableList = iu.findAllManagers();
		jobpositionsfilter = jobpositions;
	}

	public void start() {
		System.out.println("Starting app...");
		responsableList = iu.findAllManagers();
		jobpositions = ij.findAll();
	}

	public void saveJobPosition() {
		FacesContext context = FacesContext.getCurrentInstance();
		log.info("Trying to save a new position on database...");
		JobEntity ent = new JobEntity();
		ent.setCompany(company);
		ent.setCreationDate(creationDate);
		ent.setFinalDate(finalDate);
		ent.setJobDescription(jobDescription);
		ent.setJobStatus(JobStatus.OPEN);
		ent.setLocation(location);
		ent.setSla(sla);
		ent.setTechnicalArea(technicalArea);
		ent.setTitle(title);
		ent.setVacancies(vacancies);
		ent.setResponsable(iu.searchUser(responsableEmail));
		try {
			ij.saveJob(ent);
			log.info("Position saved on database!");
			context.addMessage(null, new FacesMessage("Position created!"));
			this.jobpositions.add(ent);
			this.company = "";
			this.sla = "";
			this.jobDescription = "";
			this.location = "";
			this.creationDate = null;
			this.finalDate = null;
			this.responsable = null;
			this.technicalArea = "";
			this.title = "";
			this.vacancies = "";

		} catch (Exception e) {
			log.error("Problem saving position!");
			context.addMessage(null, new FacesMessage(
					"Position creation failed!."));
			e.printStackTrace();
		}
	}

	public void clear() {
		this.company = "";
		this.sla = "";
		this.jobDescription = "";
		this.location = "";
		this.creationDate = null;
		this.finalDate = null;
		this.responsable = null;
		this.technicalArea = "";
		this.title = "";
		this.vacancies = "";
	}

	public void jobInfo(Long idPos) {
		JobEntity jent = new JobEntity();
		this.idJob = idPos;
		jent = ij.findById(idPos);
		setLocation(jent.getLocation());
		setCompany(jent.getCompany());
		setSla(jent.getSla());
		setCreationDate(jent.getCreationDate());
		setFinalDate(jent.getFinalDate());
		setResponsable(jent.getResponsable());
		setResponsableEmail(jent.getResponsable().getEmail());
		setTitle(jent.getTitle());
		setTechnicalArea(jent.getTechnicalArea());
		setJobDescription(jent.getJobDescription());
		setJobStatus(jent.getJobStatus());
		setVacancies(jent.getVacancies());
		setPositionCode(jent.getPositionCode());
	}

	public void updateJobPosition() {
		JobEntity jent = new JobEntity();
		jent.setFinalDate(this.finalDate);
		jent.setSla(this.sla);
		jent.setTitle(this.title);
		jent.setLocation(this.location);
		jent.setCompany(this.company);
		jent.setVacancies(this.vacancies);
		jent.setTechnicalArea(this.technicalArea);
		jent.setJobDescription(this.jobDescription);
		jent.setResponsable(iu.searchUser(responsableEmail));
		jent.setId(this.idJob);
		ij.updateJob(jent);
	}

	public void clearTable() {

	}

	public Date getActualDate() {
		return new Date();
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

	public List<JobEntity> getJobpositions() {
		return jobpositions;
	}

	public void setJobpositions(List<JobEntity> jobpositions) {
		this.jobpositions = jobpositions;
	}

	public String getSelectPosition() {
		return selectPosition;
	}

	public void setSelectPosition(String selectPosition) {
		this.selectPosition = selectPosition;
	}

	public JobStatus[] getJobStatuses() {
		return JobStatus.values();
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

	public List<UserEntity> getResponsableList() {
		return responsableList;
	}

	public void setResponsableList(List<UserEntity> responsableList) {
		this.responsableList = responsableList;
	}

	public String getResponsableEmail() {
		return responsableEmail;
	}

	public void setResponsableEmail(String responsableEmail) {
		this.responsableEmail = responsableEmail;
	}

	public List<JobEntity> getJobpositionsfilter() {
		return jobpositionsfilter;
	}

	public void setJobpositionsfilter(List<JobEntity> jobpositionsfilter) {
		this.jobpositionsfilter = jobpositionsfilter;
	}

	public Long getIdJob() {
		return idJob;
	}

	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

}
