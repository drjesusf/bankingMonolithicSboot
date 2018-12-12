package banking.ads.application.customers.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import banking.ads.application.customers.dtos.CustomerDto;
import banking.ads.domain.customers.contracts.CustomerRepository;
import banking.ads.domain.customers.entities.Customer;
import seedWork.Notification;

@Service
public class CustomerApplicationService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Value("${maxPageSize}")
	private int maxPageSize;
	
	public List<CustomerDto> get(int page, int pageSize) {
		Notification notification = this.getValidation(page, pageSize);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
		List<Customer> customers = this.customerRepository.get(page, pageSize);
		List<CustomerDto> customersDto = mapper.map(customers, new TypeToken<List<CustomerDto>>() {}.getType());
        return customersDto;
    }
	
	private Notification getValidation(int page, int pageSize) {
		Notification notification = new Notification();
		if (pageSize > maxPageSize) {
			notification.addError("Page size can not be greater than 100");
		}
		return notification;
	}
}
