package kodlamaio.ReCapProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.ReCapProject.business.CustomerAuthentication.CustomerLoginService;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class CustomerLoginsController {

	@Autowired
	private CustomerLoginService customerLoginService;

	@PostMapping
	public Result logCustomerIn(@RequestParam String email, @RequestParam String password) {
		
			return this.customerLoginService.logCustomerIn(email, password);
		
		
	}
	
	
	
}
