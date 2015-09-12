package services;

import interfaces.IApplication;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ApplicationDAO;
import entities.ApplicationEntity;

@Stateless
public class ApplicationImp implements IApplication {
	
@Inject
private ApplicationDAO ap;

@Override
public void saveApplication(ApplicationEntity applicationentity) {

	// verifica se pode gravar

	// se puder grava na bd

	ap.save(applicationentity);
}


}
