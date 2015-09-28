package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GuideDAO;
import entities.GuideEntity;
import interfaces.IGuide;

@Stateless
public class GuideImp implements IGuide {
	
	@Inject
	private GuideDAO gd;

	@Override
	public void saveGuide(GuideEntity ent) {
		gd.save(ent);		
	}

}
