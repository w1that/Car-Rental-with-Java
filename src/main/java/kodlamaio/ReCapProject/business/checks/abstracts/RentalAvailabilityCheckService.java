package kodlamaio.ReCapProject.business.checks.abstracts;

import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Rental;

public interface RentalAvailabilityCheckService {

	Result checkIfRentalAvailable(Rental rental);
}
