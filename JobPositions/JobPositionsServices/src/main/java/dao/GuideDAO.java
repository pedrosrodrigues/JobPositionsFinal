package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.GuideEntity;

@Stateless
public class GuideDAO {
	
	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(GuideEntity ent) {
		em.persist(ent);
	}

}
