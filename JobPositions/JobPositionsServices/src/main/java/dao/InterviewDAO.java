package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.InterviewEntity;

@Stateless
public class InterviewDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;
	
	public void saveInterview(InterviewEntity ent) {
		em.persist(ent);
	}

}
