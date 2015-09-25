package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.UserEntity;

@Local
public interface IUser {

	public UserEntity searchUser(String email);

	public void saveUser(UserEntity uent);

	public void updateUser(UserEntity uent);

	public List<UserEntity> findAllManagers();

}
