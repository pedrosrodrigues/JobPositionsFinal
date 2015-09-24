package services;

import interfaces.IApplication;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ApplicationDAO;
import entities.ApplicationEntity;

@Stateless
public class ApplicationImp implements IApplication {

	@Inject
	private ApplicationDAO ap;

	@Override
	public boolean saveApplication(ApplicationEntity aent) {
		List<ApplicationEntity> listapp = new ArrayList<>();
		boolean saved = false;
		listapp = ap.findByCandidateJob(aent.getJobEntity().getId(), aent
				.getCandidateEntity().getId());
		if (listapp.size() == 0) {
			// Gravar na BD, colocar aqui log e msg
			saved = true;
			ap.save(aent);
		} else {
			saved = false;
			// não gravar, log e msg
		}
		return saved;
	}

	@Override
	public List<ApplicationEntity> findCandApps(Long id) {
		return ap.findByCandApp(id);
	}

	@Override
	public List<ApplicationEntity> findByJobCand(Long id) {
		return ap.findByJobCand(id);
	}

//	@Override
//	public void updateCandidate(ApplicationEntity aent) {
//		// TODO Auto-generated method stub
//		
//	}

}
