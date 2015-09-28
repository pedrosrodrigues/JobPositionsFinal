package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ScriptDAO;
import entities.ScriptEntity;
import interfaces.IScript;

@Stateless
public class ScriptImp implements IScript {
	
	@Inject
	private ScriptDAO sd;

	@Override
	public void saveScript(ScriptEntity ent) {
		sd.save(ent);		
	}

}
