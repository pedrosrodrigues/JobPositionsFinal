package backingbeans;

import interfaces.ICandidate;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.CandidateEntity;
import entities.JobEntity;
import enumeration.ApplicationStatus;

@SessionScoped
@Named
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SystemUser su;
	@Inject
	private ICandidate ic;

	private Date date;
	private String email;
	private ApplicationStatus status;
	private CandidateEntity cent;
	private JobEntity jent;

	public void saveApp(int idPosition) {
		System.out.println(idPosition);
		cent = ic.findByEmail(su.getUserlogado().getEmail());

	}

}
