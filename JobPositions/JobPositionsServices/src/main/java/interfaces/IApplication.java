package interfaces;

import javax.ejb.Local;

import entities.ApplicationEntity;

@Local

public interface IApplication {

	public void saveApplication(ApplicationEntity ent);
}
