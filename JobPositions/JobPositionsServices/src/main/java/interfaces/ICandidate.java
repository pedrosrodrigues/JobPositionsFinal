package interfaces;

import javax.ejb.Local;

import entities.CandidateEntity;

@Local
public interface ICandidate {
	
	public void save(CandidateEntity ent);
	

}
