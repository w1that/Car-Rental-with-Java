package kodlamaio.ReCapProject.business.checks.abstracts;

import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Customer;

public interface CustomerPropertiesCheckService {

	Result checkIfRegistrationRulesAppropriate(Customer customer);
}
