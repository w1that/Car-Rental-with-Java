package kodlamaio.ReCapProject.business.checks.abstracts;

import kodlamaio.ReCapProject.entities.concretes.Rental;

public interface RentalAvailabilityCheckService {

	boolean checkIfRentalAvailable(Rental rental);
}
