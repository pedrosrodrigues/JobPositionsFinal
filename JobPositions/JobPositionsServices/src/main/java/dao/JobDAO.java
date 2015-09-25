package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.JobEntity;

@Stateless
public class JobDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(JobEntity ent) {
		em.persist(ent);
	}

	public void update(JobEntity ent) {
		em.merge(ent);
	}

	@SuppressWarnings("unchecked")
	public List<JobEntity> findAll() {
		Query q = em.createNamedQuery(JobEntity.FIND_ALL);
		return q.getResultList();
	}

	public JobEntity findById(Long id) {
		Query q = em.createNamedQuery(JobEntity.FIND_BY_ID);
		q.setParameter("id", id);
		return (JobEntity) q.getSingleResult();

	}

}
