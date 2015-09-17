package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "CandidateEntity.findByEmail", query="SELECT c FROM CandidateEntity c WHERE c.email like :email")})
public class CandidateEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_EMAIL = "CandidateEntity.findByEmail";

	private Long id;
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

	// FALTA AQUI CV E CARTA PEDRO NAO DORME ENQTO NAO DESCOBRIR
	// private List<Application> applications = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(nullable = false, length = 100)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false, length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(nullable = false, length = 100)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(nullable = false, length = 100)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(nullable = false, length = 50)
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Column(nullable = false, length = 50)
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	// //CASCADE PARA QDO GRAVARMOS UM CLIENTE GRAVRARMOS TB AS SUAS
	// CANDIDATURAS//
	// @OneToMany(mappedBy="candidate", cascade = CascadeType.ALL)
	// public List<Application> getApplications() {
	// return applications;
	// }
	//
	// public void setApplications(List<Application> applications) {
	// this.applications = applications;
	// }
	//
	//
	@Column(nullable = true, length = 50)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(nullable = true, length = 50)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(nullable = true, length = 100)
	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
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
		CandidateEntity other = (CandidateEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
