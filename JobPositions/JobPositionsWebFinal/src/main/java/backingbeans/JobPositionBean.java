package backingbeans;

import interfaces.IJobPosition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.JobEntity;
import enumeration.JobStatus;

@SessionScoped
@Named
public class JobPositionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IJobPosition ij;

	private Date creationDate;
	private Date finalDate;
	private String jobDescription;
	private String company;
	private String technicalArea;
	private String sla;
	private String location;
	private String title;
	private String positionCode;
	private String vacancies;
	private JobStatus jobStatus;
	// private String jobStatus;
	private String responsable;
	private String selectPosition;
	private List<JobEntity> jobpositions = new ArrayList<JobEntity>();

	private static final Logger log = LoggerFactory
			.getLogger(JobPositionBean.class);

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
		ent.setPositionCode(positionCode);
		ent.setSla(sla);
		ent.setTechnicalArea(technicalArea);
		ent.setTitle(title);
		ent.setVacancies(vacancies);
		ent.setResponsable(responsable);
		try {
			ij.saveJob(ent);
			this.jobpositions.add(ent);
			log.info("Position saved on database!");
			context.addMessage(null, new FacesMessage("Position created!"));
		} catch (Exception e) {
			log.error("Problem saving position!");
			context.addMessage(null, new FacesMessage(
					"Position creation failed!."));
			e.printStackTrace();
		}
	}

	public void start() {
		System.out.println("Starting app...");
		jobpositions = ij.findAll();
	}

	public void jobInfo(Long idPos) {
		System.out.println("estou aqui");
		System.out.println("id:" + idPos);
		JobEntity jent = new JobEntity();
		jent = ij.findById(idPos);

		System.out.println("Location db:" + jent.getLocation());
		setLocation(jent.getLocation());
		System.out.println("location bean:" + this.location);

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

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
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

}
