package services;

import java.util.List;

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

	@Override
	public List<ScriptEntity> findAll() {
		return sd.findAll();
	}

	@Override
	public ScriptEntity findByName(String scriptName) {
		return sd.findByName(scriptName);
	}

	@Override
	public void remove(ScriptEntity ent) {
		sd.remove(ent);	
	}
	
	@Override
	public ScriptEntity findById (Long id) {
		return sd.findById(id);
	}

	@Override
	public void updateScript(ScriptEntity ent) {
		sd.update(ent);	
	}
	
	


}
