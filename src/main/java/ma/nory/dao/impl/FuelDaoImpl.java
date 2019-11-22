package ma.nory.dao.impl;

import java.util.List;

import ma.nory.dao.IFuelDao;
import ma.nory.models.Fuel;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FuelDaoImpl implements IFuelDao {

	@Autowired
	private SessionFactory session;

	@Override
	public void saveFuel(Fuel fuel) {
		getSession().getCurrentSession().save(fuel);
	}

	@Override
	public void updateFuel(Fuel fuel) {
		getSession().getCurrentSession().update(fuel);
	}

	@Override
	public void deleteFuel(Fuel fuel) {
		getSession().getCurrentSession().delete(fuel);
	}

	@Override
	public Fuel findFuel(Integer id) {
		return (Fuel) getSession().getCurrentSession().get(Fuel.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Fuel> getAllFuel() {
		return getSession().getCurrentSession().createCriteria(Fuel.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fuel> findFuel(Fuel fuel) {
		Criteria criteria = getSession().getCurrentSession().createCriteria(Fuel.class);
		
		if (! fuel.getSerial().trim().equals("")) {
			criteria.add(Restrictions.eq("serial", fuel.getSerial()));
		}
		if (! fuel.getSerial22().trim().equals("")) {
			criteria.add(Restrictions.eq("serial22", fuel.getSerial22()));
		}
		if (fuel.getReportNumber() != 0) {
			criteria.add(Restrictions.eq("reportNumber", fuel.getReportNumber()));
		}
		if (! fuel.getFrs().trim().equals("")) {
			criteria.add(Restrictions.eq("frs", fuel.getFrs()));
		}
		if (fuel.getMounth() != 0) {
			criteria.add(Restrictions.eq("mounth", fuel.getMounth()));
		}
		if (fuel.getMounth2() != 0) {
			criteria.add(Restrictions.eq("mounth2", fuel.getMounth2()));
		}
		if (fuel.getYear() != 0) {
			criteria.add(Restrictions.eq("year", fuel.getYear()));
		}
		if (! fuel.getNumber().trim().equals("")) {
			criteria.add(Restrictions.eq("number", fuel.getNumber()));
		}
		if (! fuel.getAssignment().trim().equals("")) {
			criteria.add(Restrictions.eq("assignment", fuel.getAssignment()));
		}
		if (! fuel.getSector().trim().equals("")) {
			criteria.add(Restrictions.eq("sector", fuel.getSector()));
		}
		if (! fuel.getDepartment().trim().equals("")) {
			criteria.add(Restrictions.eq("department", fuel.getDepartment()));
		}
		if (fuel.getBill_number() != 0) {
			criteria.add(Restrictions.eq("bill_number", fuel.getBill_number()));
		}
		if (fuel.getBill_date() != null) {
			criteria.add(Restrictions.eq("bill_date", fuel.getBill_date()));
		}

		return criteria.list();
	}

	// GETTERS AND SETTERS
	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
}
