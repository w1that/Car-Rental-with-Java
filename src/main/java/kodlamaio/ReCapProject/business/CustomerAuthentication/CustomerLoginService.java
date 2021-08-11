package kodlamaio.ReCapProject.business.CustomerAuthentication;

import kodlamaio.ReCapProject.core.utilities.results.Result;

public interface CustomerLoginService {

	Result logCustomerIn(String email, String password);
	
}
