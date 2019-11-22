package ma.nory.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import ma.nory.excels.ImporteFuel;
import ma.nory.models.Fuel;
import ma.nory.service.IFuelService;
import ma.nory.util.AlertMessages;

@ManagedBean(name = "fuelController")
@RequestScoped
public class FuelController {

	@ManagedProperty(value = "#{fuelService}")
	private IFuelService iFuelService;
	
	private List<Fuel> fuels = new ArrayList<Fuel>(0);
	private Fuel fuel;
	private boolean value = true;
	private Part file;
	
	//Constructeurs
	public FuelController() {
		fuel = new Fuel();
	}
	
	//Méthode que j'appele dans le tableau de la page fuel.xhtml
	public List<Fuel> listeOfFuels(){
		fuels.clear();
		if(isValue())
			fuels.addAll(iFuelService.getAllFuel());
		else
			fuels.addAll(iFuelService.findFuel(fuel));
		
		return fuels;
	}
	
	//Modifier la valeur de VALUE pour faire le teste dans la méthode : listeOfFuels
		public boolean searchFuel(){
			setValue(false);
			return value;
		}
	
	//Modifier la valeur de VALUE pour faire le teste dans la méthode : listeOfFuels
	public boolean getAllFuels(){
		setValue(true);
		return value;
	}
	
	//Ajouter un nouveau carburant
	public void addNewFuel(){
		if(fuel.getMounth()>12 | fuel.getMounth()<1 ){
			AlertMessages.warning("Le (mois) doit être compris entre 1 et 12");
			return;
		}
		if(fuel.getMounth2()>12 | fuel.getMounth2()<1 ){
			AlertMessages.warning("Le (mois2) doit être compris entre 1 et 12");
			return;
		}
		iFuelService.saveFuel(fuel);
		AlertMessages.information("Les données on été ajouté avec succès.");
		fuel = new Fuel();
	}
	
	//Vider le formulaire
	public void resetForm(){
		fuel = new Fuel();
	}
	
	//Importer carburant
	public void importFuel(){
		try {
			String message = ImporteFuel.importTasksFromExcelFile(file, iFuelService);
			AlertMessages.information(message);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//Getters and Setters
	public IFuelService getiFuelService() {
		return iFuelService;
	}
	public void setiFuelService(IFuelService iFuelService) {
		this.iFuelService = iFuelService;
	}
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	public List<Fuel> getFuels() {
		return fuels;
	}
	public void setFuels(List<Fuel> fuels) {
		this.fuels = fuels;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
}