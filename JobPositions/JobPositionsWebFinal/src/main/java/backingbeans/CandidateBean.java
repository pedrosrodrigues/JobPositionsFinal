package backingbeans;

import interfaces.ICandidate;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import entities.CandidateEntity;

@SessionScoped
@Named
public class CandidateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICandidate ic;

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
	
	private static final Logger log = LoggerFactory.getLogger(CandidateBean.class);

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
			page= "/Login.xhtml?faces-redirect=true";
			
			log.info("Candidate saved!");
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					"Problem saving candidate on database!"));
			log.error("Problem saving candidate!");
			e.printStackTrace();
		}
		return page;
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

}
