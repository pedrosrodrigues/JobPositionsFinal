package backingbeans;

import interfaces.ICandidate;
import interfaces.IJobPosition;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.CandidateEntity;
import entities.JobEntity;

@SessionScoped
@Named
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SystemUser su;
	@Inject
	private ICandidate ic;
	@Inject
	private IJobPosition ijp;

	private CandidateEntity cent;
	private JobEntity jent;

	public void saveApp(int idPosition) {
		System.out.println(idPosition);
		cent = ic.findByEmail(su.getUserlogado().getEmail());
		jent = ijp.findById((long) idPosition);
		System.out.println(cent.getLastname());
		System.out.println(jent.getJobDescription());
	}
}
