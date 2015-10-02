package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ScriptEntity;

@Local
public interface IScript {

	public void saveScript(ScriptEntity ent);
	
	public List<ScriptEntity> findAll();
	
	public ScriptEntity findByName (String scriptName);

	public void remove(ScriptEntity ent);
	
	public ScriptEntity findById (Long Id);

	public void updateScript(ScriptEntity ent);
	
	
}
