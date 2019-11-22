package ma.nory.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "redirection")
@ViewScoped
public class RedirectionController {

	@ManagedProperty(value = "#{outCome}")
	private String outCome;

	public RedirectionController() {}

	//Redirection to the start page
	public String start() {
		return outCome+"?faces-redirect=true";
	}

	//GETTERS AND SETTERS
	public String getOutCome() {
		return outCome;
	}

	public void setOutCome(String outCome) {
		this.outCome = outCome;
	}

}
