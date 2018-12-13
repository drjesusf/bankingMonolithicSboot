package banking.ads.infrastructure.customers.persistence.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import banking.ads.domain.customers.contracts.CustomerRepository;
import banking.ads.domain.customers.entities.Customer;
import banking.ads.infrastructure.hibernate.HibernateRepository;

@Transactional
@Repository
public class CustomerHibernateRepositoryImpl extends HibernateRepository<Customer> implements CustomerRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	public CustomerHibernateRepositoryImpl() {
		
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> get(int page, int pageSize) {
		List<Customer> customers = null;
		//Criteria criteria = getSession().createCriteria(Customer.class);
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Customer.class);
		criteria.setFirstResult(page);
		criteria.setMaxResults(pageSize);
		customers = criteria.list();
		return customers;
	}

	@Override
	public Customer get(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
