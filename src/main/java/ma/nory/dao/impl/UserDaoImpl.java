package ma.nory.dao.impl;

import java.io.Serializable;
import java.util.List;

import ma.nory.dao.IUserDao;
import ma.nory.models.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Override
	public void addUser(User user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(User user) {
		session.getCurrentSession().delete(user);
	}

	@Override
	public User findUser(Integer userId) {
		return (User) session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User findUser(String username) {
		Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return session.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void addNewAccount(User user) {
		session.getCurrentSession().save(user);
	}

}
