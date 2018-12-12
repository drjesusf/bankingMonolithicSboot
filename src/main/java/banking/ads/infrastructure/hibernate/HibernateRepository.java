package banking.ads.infrastructure.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import seedWork.IRepository;

public class HibernateRepository<T> implements IRepository<T> {

	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T persist(T entity) {
		getSession().persist(entity);
		return entity;
	}
	
	public T save(T entity) {
		getSession().save(entity);
		return entity;
	}
	
	public T update(T entity) {
		getSession().update(entity);
		return entity;
	}

	public T merge(T entity) {
		getSession().merge(entity);
		return entity;
	}
	
	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}
}
