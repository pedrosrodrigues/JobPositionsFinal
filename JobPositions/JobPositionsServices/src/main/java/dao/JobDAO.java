package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.JobEntity;


@Stateless
public class JobDAO {
	
	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(JobEntity ent) {
		em.persist(ent);

	}

}
