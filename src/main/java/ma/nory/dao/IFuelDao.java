package ma.nory.dao;

import java.util.List;

import ma.nory.models.Fuel;

public interface IFuelDao {

	public abstract void saveFuel(Fuel fuel);

	public abstract void updateFuel(Fuel fuel);

	public abstract void deleteFuel(Fuel fuel);

	public abstract Fuel findFuel(Integer id);

	public abstract List<Fuel> findFuel(Fuel fuel);

	public abstract List<Fuel> getAllFuel();

}