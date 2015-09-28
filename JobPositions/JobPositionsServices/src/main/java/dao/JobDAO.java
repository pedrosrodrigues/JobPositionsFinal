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
		Query q = em
				.createQuery("UPDATE JobEntity SET finalDate =:finalDate, sla =:sla, title =:title, location =:location, company =:company, vacancies =:vacancies, responsable =:responsable, technicalArea =:technicalArea, jobDescription =:jobDescription WHERE id =:id");
		q.setParameter("finalDate", ent.getFinalDate());
		q.setParameter("sla", ent.getSla());
		q.setParameter("title", ent.getTitle());
		q.setParameter("location", ent.getLocation());
		q.setParameter("company", ent.getCompany());
		q.setParameter("vacancies", ent.getVacancies());
		q.setParameter("responsable", ent.getResponsable());
		q.setParameter("technicalArea", ent.getTechnicalArea());
		q.setParameter("jobDescription", ent.getJobDescription());
		q.executeUpdate();
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
