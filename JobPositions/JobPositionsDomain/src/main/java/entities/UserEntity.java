package entities;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import enumeration.RoleEntity;

@Entity
@NamedQueries({
	@NamedQuery(name = "UserEntity.findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email like :email"),
	@NamedQuery(name = "UserEntity.findAllManagers", query = "SELECT u FROM UserEntity u WHERE u.role like :role"),
	@NamedQuery(name = "UserEntity.findAllInterviewrs", query = "SELECT u FROM UserEntity u WHERE u.role like :role"),})
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_EMAIL = "UserEntity.findByEmail";
	public static final String FIND_ALL_MANAGERS = "UserEntity.findAllManagers";
	public static final String FIND_ALL_INTERVIEWERS = "UserEntity.findAllInterviewrs";


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(nullable = false, length = 100)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoleEntity role;

	@OneToMany(mappedBy = "responsable", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<JobEntity> jobList = new ArrayList<>();

	@OneToMany(mappedBy = "interviewer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<InterviewEntity> interviewesList = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<JobEntity> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobEntity> jobList) {
		this.jobList = jobList;
	}

	public List<InterviewEntity> getInterviewesList() {
		return interviewesList;
	}

	public void setInterviewesList(List<InterviewEntity> interviewesList) {
		this.interviewesList = interviewesList;
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
		UserEntity other = (UserEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
