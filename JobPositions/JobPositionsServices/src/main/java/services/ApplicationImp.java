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
	public void saveApplication(ApplicationEntity aent) {
		List<ApplicationEntity> listapp = new ArrayList<>();
		listapp = ap.findByCandidateJob(aent.getJobEntity().getId(), aent
				.getCandidateEntity().getId());

		if (listapp.size() == 0) {
			// Gravar na BD, colocar aqui log e msg
			ap.save(aent);
		} else {
			// não gravar, log e msg
		}
	}

}
