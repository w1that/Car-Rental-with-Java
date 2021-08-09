package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import kodlamaio.ReCapProject.business.abstracts.CustomerService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

@Service
public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;

	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll());
	}

	@Override
	public Result add(Customer customer) {
		this.customerDao.save(customer);
		return new SuccessResult("müşteri eklendi");
	}

	@Override
	public Result deleteByCustomerId(int id) {
		this.customerDao.deleteById(id);
		return new SuccessResult("Müşteri silindi");
	}

	@Override
	public DataResult<List<CustomerDetailsDto>> getCustomerDetails() {
		return new SuccessDataResult<List<CustomerDetailsDto>>(this.customerDao.getCustomersDetails());
	}

	
}


