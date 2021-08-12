package kodlamaio.ReCapProject.business.CustomerAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.CustomerPropertiesCheckService;
import kodlamaio.ReCapProject.core.utilities.emailSender.ActivatorService;
import kodlamaio.ReCapProject.core.utilities.emailSender.EmailSenderService;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.entities.concretes.Customer;

@Service
public class CustomerRegisterManager implements CustomerRegisterService{

	@Autowired
	private ActivatorService activatorService;
	@Autowired
	private EmailSenderService emailService;
	@Autowired
	private CustomerDao customerDao;
	@Autowired 
	CustomerPropertiesCheckService customerPropertiesCheckService;
	
	@Override
	public Result sendActivationCode(Customer customer) {
		
		if(this.customerPropertiesCheckService.checkIfRegistrationRulesAppropriate(customer).isSuccess()) {
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
		return this.customerPropertiesCheckService.checkIfRegistrationRulesAppropriate(customer);
		
		
		
	}

	@Override
	public Result activateCustomer(String enteredCode, int customerId) {
		if(enteredCode.equals(this.customerDao.getById(customerId).getActivationCode())) {
			this.customerDao.setActivated(customerId);
			return new SuccessResult("kullanıcı aktif edildi");
		}
		
		return new ErrorResult("girilen kod eşleşmedi");
	}

}
