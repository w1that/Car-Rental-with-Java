package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

public interface CustomerService {

	DataResult<List<Customer>> getAll();
	Result add(Customer customer);
	
	DataResult<List<CustomerDetailsDto>> getCustomerDetails();
}
