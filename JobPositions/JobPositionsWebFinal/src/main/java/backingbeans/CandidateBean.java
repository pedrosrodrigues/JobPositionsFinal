package backingbeans;

import interfaces.ICandidate;
import interfaces.IUser;

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
import entities.UserEntity;

@SessionScoped
@Named
public class CandidateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICandidate ic;
	@Inject
	private SystemUser su;

	@Inject
	private IUser iu;

	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String city;
	private String country;
	private String mobile;
	private String phone;
	private String course;
	private String school;
	private String password;
	private String linkedin;
	private List<CandidateEntity> candidatesList = new ArrayList<CandidateEntity>();
	private CandidateEntity candidate;

	private static final Logger log = LoggerFactory
			.getLogger(CandidateBean.class);

	public String saveCandidate() {
		FacesContext context = FacesContext.getCurrentInstance();
		CandidateEntity ent = new CandidateEntity();
		String page = "";
		log.info("Trying to save a new candidate on database...");
		ent.setAddress(address);
		ent.setCity(city);
		ent.setCountry(country);
		ent.setCourse(course);
		ent.setEmail(email);
		ent.setFirstname(firstname);
		ent.setLastname(lastname);
		ent.setLinkedin(linkedin);
		ent.setMobile(mobile);
		ent.setPassword(password);
		ent.setPhone(phone);
		ent.setSchool(school);
		try {
			ic.saveCandidate(ent);
			context.addMessage(null, new FacesMessage(
					"Candidate saved on database!"));
			page = "/Login.xhtml?faces-redirect=true";

			log.info("Candidate saved!");
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					"Problem saving candidate on database!"));
			log.error("Problem saving candidate!");
			e.printStackTrace();
		}
		return page;
	}

	public void updateCandidate() {
		FacesContext context = FacesContext.getCurrentInstance();
		CandidateEntity ent = new CandidateEntity();
		log.info("Trying to update a candidate on database...");
		ent.setAddress(address);
		ent.setCity(city);
		ent.setCountry(country);
		ent.setCourse(course);
		ent.setEmail(su.getUserlogado().getEmail());
		ent.setFirstname(firstname);
		ent.setLastname(lastname);
		ent.setLinkedin(linkedin);
		ent.setMobile(mobile);
		ent.setPassword(password);
		ent.setPhone(phone);
		ent.setSchool(school);
		try {
			ic.updateCandidate(ent);
			context.addMessage(null, new FacesMessage(
					"Candidate updated on database!"));
			log.info("Candidate updated!");
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					"Problem updating candidate on database!"));
			log.error("Problem updating candidate!");
			e.printStackTrace();
		}
		log.info("Also need to update user table!");
		UserEntity uent = new UserEntity();
		uent.setEmail(su.getUserlogado().getEmail());
		uent.setName(firstname + " " + lastname);
		uent.setPassword(password);
		iu.updateUser(uent);
		su.searchUser(su.getUserlogado().getEmail());
	}

	public void findByEmail(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.candidate = ic.findByEmail(email);
		if(candidate.getEmail()== null){
			context.addMessage(null, new FacesMessage(
					"No records found!"));
		}
	}
	
	public List<CandidateEntity> findByFirstName(String fname){
		this.candidatesList = ic.findByFistName(fname);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByLastName(String lname){
		this.candidatesList = ic.findByLastName(lname);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByAdress(String adress){
		this.candidatesList = ic.findByAdress(adress);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByCity(String city){
		this.candidatesList = ic.findByCiy(city);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByPhone(String phone){
		this.candidatesList = ic.findByPhone(city);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByMobile(String mobile){
		this.candidatesList = ic.findByMobile(mobile);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByCountry(String country){
		this.candidatesList = ic.findByCountry(country);
		return candidatesList;
	}
	
	public List<CandidateEntity> findByCourse(String course){
		this.candidatesList = ic.findByCourse(course);
		return candidatesList;
	}
	
	public List<CandidateEntity> findBySchool(String school){
		this.candidatesList = ic.findBySchool(school);
		return candidatesList;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public List<CandidateEntity> getCandidatesList() {
		return candidatesList;
	}

	public void setCandidatesList(List<CandidateEntity> candidatesList) {
		this.candidatesList = candidatesList;
	}



}
