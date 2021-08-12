package kodlamaio.ReCapProject.business.checks.concretes;

import java.util.Objects;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.RentalAvailabilityCheckService;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.entities.concretes.Rental;

@Service
public class RentalAvailabilityCheckManager implements RentalAvailabilityCheckService {

	@Override
	public Result checkIfRentalAvailable(Rental rental) {
		
		if(!rental.getCar().isBusy() && rental.getCustomer().isActivated()) {
			return new SuccessResult("başarılı!");
		}
		return new ErrorResult("başarısız");
//		if(rental.getCar().isBusy()) {
//			return new ErrorResult("Araç şuanda başka biri tarafından kiralanmış görünüyor.");
//		}
//		if(!rental.getCustomer().isActivated()) {
//			return new ErrorResult("Araç kiralayabilmeniz için hesabınızı aktif etmeniz gerekir. Posta kutunuzu kontrol edin");
//		}
		
	}

}
