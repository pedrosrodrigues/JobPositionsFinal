package services;

import interfaces.IUser;

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

}
