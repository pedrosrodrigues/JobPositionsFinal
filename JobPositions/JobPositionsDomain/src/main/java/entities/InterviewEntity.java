package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterviewEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date interviewDate;

	// private ApplicationEntity applicationEntity;
	// private UserEntity userEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	// @ManyToOne
	// @JoinColumn(name = "candidateEntity")
	// public ApplicationEntity getApplicationEntity() {
	// return applicationEntity;
	// }
	//
	// public void setApplicationEntity(ApplicationEntity applicationEntity) {
	// this.applicationEntity = applicationEntity;
	// }
	//
	// @ManyToOne
	// @JoinColumn(name = "candidateEntity")
	// public UserEntity getUserEntity() {
	// return userEntity;
	// }
	//
	// public void setUserEntity(UserEntity userEntity) {
	// this.userEntity = userEntity;
	// }
	//

}