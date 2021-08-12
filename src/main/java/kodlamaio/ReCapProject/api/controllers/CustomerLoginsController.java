package kodlamaio.ReCapProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.CustomerAuthentication.CustomerLoginService;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.dtos.CustomerLoginDto;

@RestController
@RequestMapping("/api/login")
public class CustomerLoginsController {

	@Autowired
	private CustomerLoginService customerLoginService;

	@PostMapping
	public Result logCustomerIn(@RequestParam String email, @RequestParam String password) {
		return this.customerLoginService.logCustomerIn(email, password);
	}
	
	
	
}
