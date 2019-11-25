package ma.nory.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ma.nory.models.User;
import ma.nory.service.IUserService;
import ma.nory.util.UsersData;

import org.springframework.security.core.userdetails.UserDetails;

@ManagedBean(name = "userConnected")
@SessionScoped
public class UserConnectedController {

	@ManagedProperty(value = "#{userDetailsService}")
	private IUserService iUserService;

	@ManagedProperty(value = "#{user}")
	private User user;

	public UserConnectedController() {
	}

	@PostConstruct
	public void init() {
		UserDetails userDetails = UsersData.getUsersData();
		user = iUserService.findUserByName(userDetails.getUsername());
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
