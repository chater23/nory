package ma.nory.service;

import java.util.List;

import ma.nory.models.User;


public interface IUserService {

	void addUser(User user);

	void editUser(User user);

	void deleteUser(User user);

	User findUser(int userId);

	User findUserByName(String username);

	List<User> getAllUsers();

	void addNewAccount(User user);

}
