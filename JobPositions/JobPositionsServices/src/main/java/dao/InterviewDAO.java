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

	public void updateInterview(InterviewEntity ient) {
		Query q = em
				.createQuery("UPDATE InterviewEntity SET answer1 =:answer1, answer2 =:answer2, answer3 =:answer3, answer4 =:answer4, answer5 =:answer5, feedback =:feedback, submitted =:submitted WHERE id =:idInt");
		q.setParameter("idInt", ient.getId());
		q.setParameter("answer1", ient.getAnswer1());
		q.setParameter("answer2", ient.getAnswer2());
		q.setParameter("answer3", ient.getAnswer3());
		q.setParameter("answer4", ient.getAnswer4());
		q.setParameter("answer5", ient.getAnswer5());
		q.setParameter("feedback", ient.getFeedback());
		q.setParameter("submitted", ient.isSubmitted());
		q.executeUpdate();
	}

}
