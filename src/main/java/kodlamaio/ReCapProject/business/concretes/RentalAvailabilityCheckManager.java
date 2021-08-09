package kodlamaio.ReCapProject.business.concretes;

import java.util.Objects;
import org.springframework.stereotype.Service;
import kodlamaio.ReCapProject.business.abstracts.RentalAvailabilityCheckService;
import kodlamaio.ReCapProject.entities.concretes.Rental;

@Service
public class RentalAvailabilityCheckManager implements RentalAvailabilityCheckService {

	@Override
	public boolean checkIfRentalAvailable(Rental rental) {
		if(Objects.isNull(rental.getReturnDate())) {
			return false;
		}
		return true;
	}

}
