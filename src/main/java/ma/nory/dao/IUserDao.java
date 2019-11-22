package ma.nory.dao;

import java.util.List;

import ma.nory.models.User;


public interface IUserDao {
	
	abstract void addUser(User user);
	
	abstract void updateUser(User user);
	
	abstract void deleteUser(User user);
	
	abstract User findUser(Integer userId);
	
	abstract User findUser(String username);
	
	abstract List<User> getAllUsers();
	
	abstract void addNewAccount(User user);
}	
	