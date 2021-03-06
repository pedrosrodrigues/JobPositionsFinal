package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.CandidateEntity;

@Local
public interface ICandidate {

	public void saveCandidate(CandidateEntity ent);

	public CandidateEntity findByEmail(String email);

	public void updateCandidate(CandidateEntity ent);

	public List<CandidateEntity> findByFirstName(String firstname);

	public List<CandidateEntity> findByLastName(String lastname);

	public List<CandidateEntity> findByAdress(String adress);

	public List<CandidateEntity> findByCiy(String city);

	public List<CandidateEntity> findByPhone(String phone);

	public List<CandidateEntity> findByMobile(String mobile);

	public List<CandidateEntity> findByCountry(String country);

	public List<CandidateEntity> findByCourse(String course);

	public List<CandidateEntity> findBySchool(String school);

	public List<CandidateEntity> findByEmailList(String email);

}
