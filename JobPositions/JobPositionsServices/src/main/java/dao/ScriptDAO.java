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

}
