package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CandidateEntity;

@Stateless
public class CandidateDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(CandidateEntity ent) {
		em.persist(ent);
	}

	public CandidateEntity findByEmail(String email) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_EMAIL);
		q.setParameter("email",email);
		return (CandidateEntity) q.getSingleResult();
	}

	public void update(CandidateEntity ent) {
		em.merge(ent);		
	}

	

}
