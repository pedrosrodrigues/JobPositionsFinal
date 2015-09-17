package interfaces;

import javax.ejb.Local;

import entities.CandidateEntity;

@Local
public interface ICandidate {

	public void saveCandidate(CandidateEntity ent);

	public CandidateEntity findByEmail(String email);

}
