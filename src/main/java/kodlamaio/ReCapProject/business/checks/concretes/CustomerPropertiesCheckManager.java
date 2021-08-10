package kodlamaio.ReCapProject.business.checks.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.CustomerPropertiesCheckService;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;

@Service
public class CustomerPropertiesCheckManager implements CustomerPropertiesCheckService{

	CustomerDao customerDao;
	
	@Autowired
	public CustomerPropertiesCheckManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public boolean checkIfEmailIsUnique(String email) {
		for (Customer customer: this.customerDao.findAll()) {
			if(customer.getEmail()==email) {
				return false;
			}
		}
		return true;
	}

	
}
