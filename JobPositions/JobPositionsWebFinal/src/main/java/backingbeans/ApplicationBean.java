package backingbeans;

import interfaces.IApplication;
import interfaces.ICandidate;
import interfaces.IJobPosition;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.ApplicationEntity;
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
	@Inject
	private IJobPosition ijp;
	@Inject
	private IApplication ia;

	private CandidateEntity cent;
	private JobEntity jent;

	public void saveApp(int idPosition) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();
		System.out.println(idPosition);
		cent = ic.findByEmail(su.getUserlogado().getEmail());
		jent = ijp.findById((long) idPosition);
		System.out.println(cent.getLastname());
		System.out.println(jent.getJobDescription());
		ApplicationEntity aent = new ApplicationEntity();
		aent.setCandidateEntity(cent);
		aent.setJobEntity(jent);
		aent.setAppStatus(ApplicationStatus.OPEN);
		aent.setAplicationDate(dateobj);
		ia.saveApplication(aent);

	}
}
