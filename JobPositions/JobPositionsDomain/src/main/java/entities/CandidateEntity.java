package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "CandidateEntity.findByEmail", query = "SELECT c FROM CandidateEntity c WHERE c.email like :email"),
		@NamedQuery(name = "CandidateEntity.findByEmailList", query = "SELECT c FROM CandidateEntity c WHERE c.email like :email"),
		@NamedQuery(name = "CandidateEntity.findByFName", query = "SELECT c FROM CandidateEntity c WHERE c.firstname like :firstname "),
		@NamedQuery(name = "CandidateEntity.findByLName", query = "SELECT c FROM CandidateEntity c WHERE c.lastname like :lastname "),
		@NamedQuery(name = "CandidateEntity.findByAdress", query = "SELECT c FROM CandidateEntity c WHERE c.address like :address "),
		@NamedQuery(name = "CandidateEntity.findByCity", query = "SELECT c FROM CandidateEntity c WHERE c.city like :city "),
		@NamedQuery(name = "CandidateEntity.findByCountry", query = "SELECT c FROM CandidateEntity c WHERE c.country like :country "),
		@NamedQuery(name = "CandidateEntity.findByMobile", query = "SELECT c FROM CandidateEntity c WHERE c.mobile like :mobile "),
		@NamedQuery(name = "CandidateEntity.findByPhone", query = "SELECT c FROM CandidateEntity c WHERE c.phone like :phone "),
		@NamedQuery(name = "CandidateEntity.findByCourse", query = "SELECT c FROM CandidateEntity c WHERE c.course like :course "),
		@NamedQuery(name = "CandidateEntity.findBySchool", query = "SELECT c FROM CandidateEntity c WHERE c.school like :school ") })
public class CandidateEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_EMAIL = "CandidateEntity.findByEmail";
	public static final String FIND_BY_EMAIL_LIST = "CandidateEntity.findByEmailList";
	public static final String FIND_BY_FIRSTNAME = "CandidateEntity.findByFName";
	public static final String FIND_BY_LASTNAME = "CandidateEntity.findByLName";
	public static final String FIND_BY_ADRESS = "CandidateEntity.findByAdress";
	public static final String FIND_BY_CITY = "CandidateEntity.findByCity";
	public static final String FIND_BY_COUNTRY = "CandidateEntity.findByCountry";
	public static final String FIND_BY_MOBILE = "CandidateEntity.findByMobile";
	public static final String FIND_BY_PHONE = "CandidateEntity.findByPhone";
	public static final String FIND_BY_COURSE = "CandidateEntity.findByCourse";
	public static final String FIND_BY_SCHOOL = "CandidateEntity.findBySchool";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, length = 100)
	private String firstname;

	@Column(nullable = false, length = 100)
	private String lastname;

	private String email;

	@Column(nullable = false, length = 100)
	private String address;

	@Column(nullable = false, length = 100)
	private String city;

	@Column(nullable = false, length = 100)
	private String country;

	@Column(nullable = false, length = 20)
	private String mobile;

	@Column(nullable = false, length = 20)
	private String phone;

	@Column(nullable = false, length = 100)
	private String course;

	@Column(nullable = false, length = 100)
	private String school;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(nullable = true, length = 100)
	private String linkedin;

	@OneToMany(mappedBy = "candidateEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ApplicationEntity> appList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public List<ApplicationEntity> getAppList() {
		return appList;
	}

	public void setAppList(List<ApplicationEntity> appList) {
		this.appList = appList;
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
