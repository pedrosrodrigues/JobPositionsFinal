package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ApplicationEntity;

@Local
public interface IApplication {

	public boolean saveApplication(ApplicationEntity ent);

	public ApplicationEntity findById(Long id);

	public List<ApplicationEntity> findCandApps(Long id);

	public List<ApplicationEntity> findByJobCand(Long id);

	public void updateApplication(ApplicationEntity aent);

	public List<ApplicationEntity> findGenAppCand();

}
