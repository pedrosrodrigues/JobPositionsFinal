package interfaces;

import javax.ejb.Local;

import entities.ScriptEntity;

@Local
public interface IScript {

	public void saveScript(ScriptEntity ent);
}
