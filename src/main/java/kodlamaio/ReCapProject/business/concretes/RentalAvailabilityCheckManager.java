package kodlamaio.ReCapProject.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.RentalAvailabilityCheckService;
import kodlamaio.ReCapProject.entities.concretes.Rental;

@Service
public class RentalAvailabilityCheckManager implements RentalAvailabilityCheckService {

	@Override
	public boolean checkIfRentalAvailable(Rental rental) {
		if(rental.getReturnDate() ==null) {
			return false;
		}
		return true;
	}

}
