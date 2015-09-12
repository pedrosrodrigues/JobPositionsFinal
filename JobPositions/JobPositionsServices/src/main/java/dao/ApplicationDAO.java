package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.ApplicationEntity;

@Stateless
public class ApplicationDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(ApplicationEntity ent) {
		em.persist(ent);

	}

}