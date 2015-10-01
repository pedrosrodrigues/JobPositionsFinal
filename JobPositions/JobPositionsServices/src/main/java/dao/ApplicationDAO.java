package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.ApplicationEntity;

@Stateless
public class ApplicationDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(ApplicationEntity ent) {
		em.persist(ent);
	}

	@SuppressWarnings("unchecked")
	public List<ApplicationEntity> findByCandidateJob(Long idJob, Long idCan) {
		Query q = em.createNamedQuery(ApplicationEntity.FIND_BY_CANJOB);
		q.setParameter("idJob", idJob);
		q.setParameter("idCan", idCan);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ApplicationEntity> findByCandApp(Long idCan) {
		Query q = em.createNamedQuery(ApplicationEntity.FIND_BY_CANDAPP);
		q.setParameter("idCan", idCan);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ApplicationEntity> findByJobCand(Long idJob) {
		Query q = em.createNamedQuery(ApplicationEntity.FIND_BY_JOBCAND);
		q.setParameter("idJob", idJob);
		return q.getResultList();
	}

	public void update(ApplicationEntity aent) {
		Query q = em
				.createQuery("UPDATE ApplicationEntity SET appStatus =:appStatus WHERE id =:idApplication");
		q.setParameter("idApplication", aent.getId());
		q.setParameter("appStatus", aent.getAppStatus());
		q.executeUpdate();
	}

	public ApplicationEntity findById(Long id) {
		Query q = em.createNamedQuery(ApplicationEntity.FIND_BY_ID);
		q.setParameter("id", id);
		return (ApplicationEntity) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<ApplicationEntity> findGenAppCand() {
		Query q = em.createNamedQuery(ApplicationEntity.FIND_GEN_APP_CAND);
		q.setParameter("title", "General Application");
		return q.getResultList();
	}

}