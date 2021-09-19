package kodlamaio.ReCapProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.CustomerAuthentication.CustomerRegisterService;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Customer;

@RestController
@RequestMapping("/api/register")
@CrossOrigin
public class CustomerRegistersController {

	@Autowired
	CustomerRegisterService customerRegisterService;
	
	@PostMapping("/sendActivationCode")
	public Result sendActivationCode(@RequestBody Customer customer) {
		return this.customerRegisterService.sendActivationCode(customer);
	}
	
	@PostMapping("/activateCustomer")
	public Result activateCustomer(@RequestParam String enteredActivationCode, @RequestParam int customerId) {
		return this.customerRegisterService.activateCustomer(enteredActivationCode, customerId);
	}
}
