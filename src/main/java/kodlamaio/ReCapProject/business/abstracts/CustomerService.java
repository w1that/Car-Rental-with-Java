package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

public interface CustomerService {

	DataResult<List<Customer>> getAll();
//	Result sendActivationCode(Customer customer);
//	Result activateCustomer(String enteredCode, int customerId);
	Result add(Customer customer);
	
	Result deleteByCustomerId(int id);
	
	DataResult<List<CustomerDetailsDto>> getCustomerDetails();
}
