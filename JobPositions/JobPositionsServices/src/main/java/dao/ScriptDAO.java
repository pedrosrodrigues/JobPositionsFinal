package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.ScriptEntity;

@Stateless
public class ScriptDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(ScriptEntity ent) {
		em.persist(ent);
	}

	@SuppressWarnings("unchecked")
	public List<ScriptEntity> findAll() {
		Query q = em.createNamedQuery(ScriptEntity.FIND_ALL);
		return q.getResultList();
	}

	public ScriptEntity findByName(String scriptName) {
		Query q = em.createNamedQuery(ScriptEntity.FIND_BY_NAME);
		q.setParameter("scriptName", scriptName);
		return (ScriptEntity) q.getSingleResult();
	}

	public void remove(ScriptEntity ent) {
		em.remove(ent);		
	}

	public ScriptEntity findById(Long id) {
		Query q = em.createNamedQuery(ScriptEntity.FIND_BY_ID);
		q.setParameter("id", id);
		return (ScriptEntity) q.getSingleResult();
	}

	public void update(ScriptEntity ent) {
		Query q = em.createQuery("UPDATE ScriptEntity SET scriptName =:scriptName, question1 =:question1, question2 =:question2, question3 =:question3, question4 =:question4, question5 =:question5, expquestion1 =:expquestion1, expquestion2 =:expquestion2, expquestion3 =:expquestion3, expquestion4 =:expquestion4, expquestion5 =:expquestion5 WHERE id =:id");
		q.setParameter("scriptName", ent.getScriptName());
		q.setParameter("question1", ent.getQuestion1());
		q.setParameter("question2", ent.getQuestion2());
		q.setParameter("question3", ent.getQuestion3());
		q.setParameter("question4", ent.getQuestion4());
		q.setParameter("question5", ent.getQuestion5());
		q.setParameter("expquestion1", ent.getExpquestion1());
		q.setParameter("expquestion2", ent.getExpquestion2());
		q.setParameter("expquestion3", ent.getExpquestion3());
		q.setParameter("expquestion4", ent.getExpquestion4());
		q.setParameter("expquestion5", ent.getExpquestion5());
		q.setParameter("id", ent.getId());
		q.executeUpdate();
	}

}
