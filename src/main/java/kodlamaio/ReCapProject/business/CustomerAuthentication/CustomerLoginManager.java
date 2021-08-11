package kodlamaio.ReCapProject.business.CustomerAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;

@Service
public class CustomerLoginManager implements CustomerLoginService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Result logCustomerIn(String email, String password) {
		Customer customer = this.customerDao.getByEmail(email);
		if(new BCryptPasswordEncoder().matches(password, customer.getPassword())) {
			return new SuccessResult("başarıyla giriş yapıldı");
		}
		return new ErrorResult("giriş yapılamadı");
		
	}

}
