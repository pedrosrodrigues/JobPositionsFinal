package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.UserEntity;

@Stateless
public class UserDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(UserEntity ent) {
		em.persist(ent);
	}

	public UserEntity findEmail(String email) {
		Query q = em.createNamedQuery(UserEntity.FIND_BY_EMAIL);
		q.setParameter("email", email);
		return (UserEntity) q.getSingleResult();
	}

	public void updateUser(UserEntity uent) {
		Query q = em
				.createQuery("UPDATE UserEntity SET name =:name, password =:password WHERE email =:email");
		q.setParameter("name", uent.getName());
		q.setParameter("password", uent.getPassword());
		q.setParameter("email", uent.getEmail());
		q.executeUpdate();
	}
}
