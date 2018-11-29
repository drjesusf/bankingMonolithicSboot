package banking.ads.infrastructure.customers.persistence.hibernate.repository;

import banking.ads.domain.customers.contracts.ICustomerRepository;
import banking.ads.domain.customers.entities.Customer;
import banking.ads.infrastructure.hibernate.HibernateRepository;

public class CustomerHibernateRepositoryImpl extends HibernateRepository<Customer> implements ICustomerRepository{
	public CustomerHibernateRepositoryImpl() {
		
	}
}
