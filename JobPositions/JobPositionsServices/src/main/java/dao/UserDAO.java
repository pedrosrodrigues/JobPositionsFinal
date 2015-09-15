package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.UserEntity;

@Stateless
public class UserDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(UserEntity ent) {
		em.persist(ent);

	}
}
