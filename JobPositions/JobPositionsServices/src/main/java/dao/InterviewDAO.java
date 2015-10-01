package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.InterviewEntity;

@Stateless
public class InterviewDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void saveInterview(InterviewEntity ent) {
		em.persist(ent);
	}

	@SuppressWarnings("unchecked")
	public List<InterviewEntity> findMyInterviews(Long id) {
		Query q = em.createNamedQuery(InterviewEntity.FIND_BY_ID);
		q.setParameter("id", id);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<InterviewEntity> findAll() {
		Query q = em.createNamedQuery(InterviewEntity.FIND_ALL);
		return q.getResultList();
	}
	
	public InterviewEntity findIntById(Long id) {
		Query q = em.createNamedQuery(InterviewEntity.FIND_BY_ID_INT);
		q.setParameter("id", id);
		return (InterviewEntity) q.getSingleResult();
	}
	
	

}
