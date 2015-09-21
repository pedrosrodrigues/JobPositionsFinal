package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CandidateEntity;

@Stateless
public class CandidateDAO {

	@PersistenceContext(name = "JP")
	private EntityManager em;

	public void save(CandidateEntity ent) {
		em.persist(ent);
	}

	public CandidateEntity findByEmail(String email) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_EMAIL);
		q.setParameter("email", email);
		return (CandidateEntity) q.getSingleResult();
	}

	public void update(CandidateEntity ent) {
		Query q = em
				.createQuery("UPDATE CandidateEntity SET firstname =:firstname, lastname =:lastname, address =:address, city =:city, country =:country, mobile =:mobile, phone =:phone, course =:course, school =:school, password =:password, linkedin =:linkedin WHERE email =:email");
		q.setParameter("firstname", ent.getFirstname());
		q.setParameter("lastname", ent.getLastname());
		q.setParameter("address", ent.getAddress());
		q.setParameter("city", ent.getCity());
		q.setParameter("country", ent.getCountry());
		q.setParameter("mobile", ent.getMobile());
		q.setParameter("phone", ent.getPhone());
		q.setParameter("course", ent.getCourse());
		q.setParameter("school", ent.getSchool());
		q.setParameter("password", ent.getPassword());
		q.setParameter("linkedin", ent.getLinkedin());
		q.setParameter("email", ent.getEmail());
		q.executeUpdate();
	}

}
