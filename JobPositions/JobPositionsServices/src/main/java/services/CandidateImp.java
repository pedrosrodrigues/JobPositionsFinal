package services;

import interfaces.ICandidate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CandidateDAO;
import dao.UserDAO;
import entities.CandidateEntity;
import entities.UserEntity;
import enumeration.RoleEntity;

@Stateless
public class CandidateImp implements ICandidate {

	@Inject
	private CandidateDAO cd;
	@Inject
	private UserDAO ud;

	@Override
	public void saveCandidate(CandidateEntity candidateentity) {
		try {
			candidateentity.setPassword(passEncript(candidateentity
					.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cd.save(candidateentity);
		UserEntity uent = new UserEntity();
		uent.setEmail(candidateentity.getEmail());
		uent.setPassword(candidateentity.getPassword());
		uent.setName(candidateentity.getFirstname() + " "
				+ candidateentity.getLastname());
		uent.setRole(RoleEntity.CANDIDATE);
		ud.save(uent);
	}

	public static String passEncript(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String securedPassword = "";

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());

			byte byteData[] = md.digest();
			byte[] data2 = Base64.getEncoder().encode(byteData);
			securedPassword = new String(data2);
			return securedPassword;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return securedPassword;
	}

	@Override
	public CandidateEntity findByEmail(String email) {
		return cd.findByEmail(email);

	}

	@Override
	public void updateCandidate(CandidateEntity ent) {
		System.out.println(ent.getCountry());
		try {
			ent.setPassword(passEncript(ent.getPassword()));
			cd.update(ent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CandidateEntity> findByFirstName(String firstname) {
		return cd.findByFirstName(firstname);
	}

	@Override
	public List<CandidateEntity> findByLastName(String lname) {
		return cd.findByLastName(lname);
	}

	@Override
	public List<CandidateEntity> findByAdress(String adress) {
		return cd.findByAdress(adress);
	}

	@Override
	public List<CandidateEntity> findByCiy(String city) {
		return cd.findByCiy(city);
	}

	@Override
	public List<CandidateEntity> findByPhone(String phone) {
		return cd.findByPhone(phone);
	}

	@Override
	public List<CandidateEntity> findByMobile(String mobile) {
		return cd.findByMobile(mobile);
	}

	@Override
	public List<CandidateEntity> findByCountry(String country) {
		return cd.findByCountry(country);
	}

	@Override
	public List<CandidateEntity> findByCourse(String course) {
		return cd.findByCourse(course);
	}

	@Override
	public List<CandidateEntity> findBySchool(String school) {
		return cd.findBySchool(school);
	}

	@Override
	public List<CandidateEntity> findByEmailList(String email) {
		return cd.findByEmailList(email);
	}

}
