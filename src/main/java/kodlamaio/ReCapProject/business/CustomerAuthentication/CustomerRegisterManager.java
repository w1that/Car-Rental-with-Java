package kodlamaio.ReCapProject.business.CustomerAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.CustomerPropertiesCheckService;
import kodlamaio.ReCapProject.business.constants.Messages;
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
						Messages.messageBody(customer, activationCode),
						Messages.messageSubject
						); 
			}catch( Exception e ){
				return new ErrorResult(Messages.emailValidError);
			}
			
			String encoded = new BCryptPasswordEncoder().encode(customer.getPassword());
			customer.setPassword(encoded);
			this.customerDao.save(customer);
			System.out.println(activationCode);
			return new SuccessResult(Messages.activationCodeSent(customer));
		}
		return this.customerPropertiesCheckService.checkIfRegistrationRulesAppropriate(customer);
		
		
		
	}

	@Override
	public Result activateCustomer(String enteredCode, int customerId) {
		if(enteredCode.equals(this.customerDao.getById(customerId).getActivationCode())) {
			this.customerDao.setActivated(customerId);
			return new SuccessResult(Messages.customerActivated);
		}
		
		return new ErrorResult(Messages.activationCodeError);
	}

}
