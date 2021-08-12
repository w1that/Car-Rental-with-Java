package kodlamaio.ReCapProject.business.CustomerAuthentication;

import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Customer;

public interface CustomerRegisterService {
	
	Result sendActivationCode(Customer customer);
	Result activateCustomer(String enteredCode ,int customerId);
	
}
