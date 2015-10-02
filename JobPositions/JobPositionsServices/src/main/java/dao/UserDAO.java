package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.UserEntity;
import enumeration.RoleEntity;

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

	@SuppressWarnings("unchecked")
	public List<UserEntity> findAllManagers() {
		Query q = em.createNamedQuery(UserEntity.FIND_ALL_MANAGERS);
		q.setParameter("role", RoleEntity.MANAGER);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserEntity> findAllInterviewers() {
		Query q = em.createNamedQuery(UserEntity.FIND_ALL_INTERVIEWERS);
		q.setParameter("role", RoleEntity.INTERVIEWER);
		return q.getResultList();
	}

	public void updatePass(UserEntity user) {
		Query q = em
				.createQuery("UPDATE UserEntity SET password =:password WHERE email =:email");
		q.setParameter("password", user.getPassword());
		q.setParameter("email", user.getEmail());
		q.executeUpdate();

	}
}
