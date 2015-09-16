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

	@SuppressWarnings("unchecked")
	public List<JobEntity> findAll(){
		Query q = em.createNamedQuery(JobEntity.FIND_ALL);
		return q.getResultList();
	}
}
