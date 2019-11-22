package ma.nory.service.impl;
	
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ma.nory.dao.IUserDao;
import ma.nory.models.Role;
import ma.nory.models.User;
import ma.nory.models.UserStatus;
import ma.nory.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
	
@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, IUserService , Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findUser(username);
		if(user!=null){
			String password = user.getPassword();
			//additional information on the security object
			boolean enabled 							= user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired 		= user.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired 	= user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked 			= user.getStatus().equals(UserStatus.ACTIVE);
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : user.getRoles()){
				authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
			}
			
			//Now let's create Spring Security User object
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User Not Found!!!");
		}
	}
	
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Transactional
	public void editUser(User user) {
		userDao.updateUser(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	
	@Transactional
	public User findUser(int userId) {
		return userDao.findUser(userId);
	}
	
	@Transactional
	public User findUserByName(String username) {
		return userDao.findUser(username);
	}
	
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public void addNewAccount(User user) {
		userDao.addNewAccount(user);
	}
	
}	
	