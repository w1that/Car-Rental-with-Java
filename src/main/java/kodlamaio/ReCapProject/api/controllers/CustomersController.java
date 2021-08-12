package kodlamaio.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.abstracts.CustomerService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;
	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Customer>> getAll(){
		return this.customerService.getAll();
	}
	
	
	@GetMapping("/getCustomerDetails")
	public DataResult<List<CustomerDetailsDto>> getCustomerDetails(){
		return this.customerService.getCustomerDetails();
	}
	
	@DeleteMapping("/delete")
	public Result deleteById(@RequestParam int id) {
		return this.customerService.deleteByCustomerId(id);
	}
	
	
	
}
