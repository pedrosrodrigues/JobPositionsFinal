package populate;

import interfaces.IUser;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import services.CandidateImp;
import entities.UserEntity;
import enumeration.RoleEntity;

@ApplicationScoped
@Named
public class Populator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IUser iu;

	public void populate() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		UserEntity uent = new UserEntity();
		uent.setEmail("admin@gmail.com");
		uent.setPassword(CandidateImp.passEncript("123456"));
		uent.setName("System Administrator");
		uent.setRole(RoleEntity.ADMINISTRATOR);
		iu.saveUser(uent);
		UserEntity uent2 = new UserEntity();
		uent2.setEmail("manager@gmail.com");
		uent2.setPassword(CandidateImp.passEncript("123456"));
		uent2.setName("Position Manager");
		uent2.setRole(RoleEntity.MANAGER);
		iu.saveUser(uent2);
		UserEntity uent3 = new UserEntity();
		uent3.setEmail("interviewer@gmail.com");
		uent3.setPassword(CandidateImp.passEncript("123456"));
		uent3.setName("Application Interviewer");
		uent3.setRole(RoleEntity.INTERVIEWER);
		iu.saveUser(uent3);
		UserEntity uent4 = new UserEntity();
		uent4.setEmail("joaomanager@gmail.com");
		uent4.setPassword(CandidateImp.passEncript("123456"));
		uent4.setName("João Manager");
		uent4.setRole(RoleEntity.MANAGER);
		iu.saveUser(uent4);
		UserEntity uent5 = new UserEntity();
		uent3.setEmail("sergiointerviewer@gmail.com");
		uent3.setPassword(CandidateImp.passEncript("123456"));
		uent3.setName("Sergio Interviewer");
		uent3.setRole(RoleEntity.INTERVIEWER);
		iu.saveUser(uent5);

	}
}
