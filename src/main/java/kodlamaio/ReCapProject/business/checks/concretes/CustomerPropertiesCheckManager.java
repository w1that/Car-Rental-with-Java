package kodlamaio.ReCapProject.business.checks.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.CustomerPropertiesCheckService;
import kodlamaio.ReCapProject.business.constants.Messages;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;

@Service
public class CustomerPropertiesCheckManager implements CustomerPropertiesCheckService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Result checkIfRegistrationRulesAppropriate(Customer customer) {
		if(customer.getFirstName().matches(".*\\d.*") || customer.getLastName().matches(".*\\d.*")) {
			return new ErrorResult(Messages.nameSurnameError);
		}
		if(customer.getPassword().length()<6) {
			return new ErrorResult(Messages.passwordError);
		}
		if(this.customerDao.getByEmail(customer.getEmail())!=null) {
			return new ErrorResult(Messages.emailError);
		}
		
		return new SuccessResult();
	}
	
	

	
}
