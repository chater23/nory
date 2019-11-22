package ma.nory.service.impl;

import java.util.List;

import ma.nory.dao.IFuelDao;
import ma.nory.models.Fuel;
import ma.nory.service.IFuelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fuelService")
public class FuelServiceImpl implements IFuelService  {

	@Autowired
	private IFuelDao fuelDao;

	@Transactional
	public void saveFuel(Fuel fuel) {
		fuelDao.saveFuel(fuel);
	}

	@Transactional
	public void updateFuel(Fuel fuel) {
		fuelDao.updateFuel(fuel);
	}

	@Transactional
	public void deleteFuel(Fuel fuel) {
		fuelDao.deleteFuel(fuel);
	}

	@Transactional
	public Fuel findFuel(Integer id) {
		return fuelDao.findFuel(id);
	}

	@Transactional
	public List<Fuel> getAllFuel() {
		return fuelDao.getAllFuel();
	}

	@Transactional
	public List<Fuel> findFuel(Fuel fuel) {
		return fuelDao.findFuel(fuel);
	}

}
