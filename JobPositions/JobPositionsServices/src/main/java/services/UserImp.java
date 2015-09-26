package services;

import interfaces.IUser;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UserDAO;
import entities.UserEntity;

@Stateless
public class UserImp implements IUser {

	@Inject
	private UserDAO ud;

	@Override
	public UserEntity searchUser(String email) {
		return ud.findEmail(email);
	}

	@Override
	public void saveUser(UserEntity uent) {
		ud.save(uent);
	}

	@Override
	public void updateUser(UserEntity uent) {
		// TODO Auto-generated method stub
		try {
			uent.setPassword(CandidateImp.passEncript(uent.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ud.updateUser(uent);
	}

	@Override
	public List<UserEntity> findAllManagers() {
		return ud.findAllManagers();
	}

	@Override
	public List<UserEntity> findAllInterviewers() {
		return ud.findAllInterviewers();
	}

}
