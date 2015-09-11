package backingbeans;

import interfaces.ICandidate;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.CandidateEntity;


@SessionScoped
@Named
public class CandidateBean implements Serializable{
	
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
	
	public void save(){
		CandidateEntity ent = new CandidateEntity();
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
		ic.save(ent);
		System.out.println(city);
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
