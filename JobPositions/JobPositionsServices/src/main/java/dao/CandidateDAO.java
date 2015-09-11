package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.CandidateEntity;

@Stateless
public class CandidateDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(CandidateEntity ent) {
		em.persist(ent);

	}

}
