package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.ApplicationEntity;
import entities.JobEntity;

@Stateless
public class ApplicationDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(ApplicationEntity ent) {
		em.persist(ent);
	}

	public ApplicationEntity findByCandidateJob(Long idJob, Long idCan) {
		Query q = em.createNamedQuery(ApplicationEntity.FIND_BY_CANJOB);
		q.setParameter("id", idJob);
		q.setParameter("id", idCan);
		return (ApplicationEntity) q.getResultList();	
	}

}