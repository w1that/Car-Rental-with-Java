package kodlamaio.ReCapProject.business.concretes;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import kodlamaio.ReCapProject.business.abstracts.CustomerService;
import kodlamaio.ReCapProject.business.checks.abstracts.CustomerPropertiesCheckService;
import kodlamaio.ReCapProject.core.utilities.emailSender.ActivatorService;
import kodlamaio.ReCapProject.core.utilities.emailSender.EmailSenderService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

@Service
public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	private CustomerPropertiesCheckService customerPropertiesCheckService;
	private EmailSenderService emailService;
	private ActivatorService activatorService;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, CustomerPropertiesCheckService customerPropertiesCheckService
			,EmailSenderService emailService, ActivatorService activatorService
			) {
		super();
		this.customerDao = customerDao;
		this.customerPropertiesCheckService=customerPropertiesCheckService;
		this.emailService=emailService;
		this.activatorService=activatorService;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll());
	}

	@Override
	public Result sendActivationCode(Customer customer)  {
		String activationCode = activatorService.generateActivationCode();
		customer.setActivationCode(activationCode);
		
		try {
			emailService.sendSimpleEmail(
					customer.getEmail(),
					"Sayın " +customer.getFirstName().substring(0, 1).toUpperCase() + customer.getFirstName().substring(1) + " " + customer.getLastName().toUpperCase()+ " Hoşgeldiniz! \nHesabınızı aktif etmeniz ve araç kiralama imkanı için aktivasyon kodu: \n\n"+activationCode,
					"aktivasyon kodu"
					); 
		}catch( Exception e ){
			return new ErrorResult("mail gönderilemedi");
		}
		
		String encoded = new BCryptPasswordEncoder().encode(customer.getPassword());
		customer.setPassword(encoded);
		this.customerDao.save(customer);
		System.out.println(activationCode);
		return new SuccessResult("aktivasyon kodu gönderildi: " + customer.getEmail());
			
	}
	
	@Override
	public Result activateCustomer(String enteredCode ,int customerId) {
		if(enteredCode.equals(this.customerDao.getById(customerId).getActivationCode())) {
			this.customerDao.setActivated(customerId);
			return new SuccessResult("kullanıcı aktif edildi");
		}
		
		return new ErrorResult("girilen kod eşleşmedi");
		
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


