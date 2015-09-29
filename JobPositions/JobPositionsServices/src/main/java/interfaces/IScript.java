package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ScriptEntity;

@Local
public interface IScript {

	public void saveScript(ScriptEntity ent);
	
	public List<ScriptEntity> findAll();
}
