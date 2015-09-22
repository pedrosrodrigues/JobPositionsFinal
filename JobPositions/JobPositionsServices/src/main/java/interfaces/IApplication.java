package interfaces;

import javax.ejb.Local;

import entities.ApplicationEntity;

@Local
public interface IApplication {

	public boolean saveApplication(ApplicationEntity ent);
	
	
}
