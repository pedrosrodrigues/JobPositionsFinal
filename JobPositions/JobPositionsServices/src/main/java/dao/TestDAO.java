package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.TestEntity;

@Stateless
@LocalBean
public class TestDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(TestEntity ent) {

		em.persist(ent);
		// TODO Auto-generated method stub

	}

}
