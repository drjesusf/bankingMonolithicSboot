package banking.ads.domain.customers.contracts;

import java.util.List;

import banking.ads.domain.customers.entities.Customer;

//extends IRepository<Customer> 
public interface CustomerRepository{	
	public Customer save(Customer customer);
	public List<Customer> get(int page, int pageSize);
	public Customer get(long customerId);
}
