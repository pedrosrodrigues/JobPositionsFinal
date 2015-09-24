package dao;

import java.util.List;

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
	

	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByFistName(String fname) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_FIRSTNAME);
		q.setParameter("firstname", fname);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByLastName(String lname) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_LASTNAME);
		q.setParameter("lastname", lname);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByAdress(String adress) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_ADRESS);
		q.setParameter("address", adress);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByCiy(String city) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_CITY);
		q.setParameter("City", city);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByPhone(String phone) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_PHONE);
		q.setParameter("phone", phone);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByMobile(String mobile) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_LASTNAME);
		q.setParameter("mobile", mobile);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByCountry(String country) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_COUNTRY);
		q.setParameter("country", country);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findByCourse(String course) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_COURSE);
		q.setParameter("course", course);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CandidateEntity> findBySchool(String school) {
		Query q = em.createNamedQuery(CandidateEntity.FIND_BY_SCHOOL);
		q.setParameter("school", school);
		return q.getResultList();
	}
}
