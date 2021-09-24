package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Rental;
import kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto;

public interface RentalService {

	DataResult<List<Rental>> getAll();
	/*Result add(Rental rental);*/
	Result add(int customerId, int carId);
	Result deleteById(int id);
	/*Result deleteAll();*/
	DataResult<List<RentalDetailsDto>> getRentalDetail();
	Result setReturnDate(int id);
}
