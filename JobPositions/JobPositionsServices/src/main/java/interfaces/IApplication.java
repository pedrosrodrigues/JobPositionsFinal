package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ApplicationEntity;

@Local
public interface IApplication {

	public boolean saveApplication(ApplicationEntity ent);

	public List<ApplicationEntity> findCandApps(Long id);
	
	public List<ApplicationEntity> findByJobCand(Long id);

//	public void updateCandidate(ApplicationEntity aent);

}
