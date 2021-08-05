package kodlamaio.ReCapProject.business.abstracts;

import kodlamaio.ReCapProject.entities.concretes.Rental;

public interface RentalAvailabilityCheckService {

	boolean checkIfRentalAvailable(Rental rental);
}
