package interfaces;

import javax.ejb.Local;

import entities.UserEntity;

@Local
public interface IUser {

	public UserEntity searchUser(String email);

	public void saveUser(UserEntity uent);

}
