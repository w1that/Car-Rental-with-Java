package kodlamaio.ReCapProject.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.ReCapProject.business.abstracts.RentalAvailabilityCheckService;
import kodlamaio.ReCapProject.business.abstracts.RentalService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.RentalDao;
import kodlamaio.ReCapProject.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService{
	
	private RentalDao rentalDao;
	private RentalAvailabilityCheckService rentalAvailabilityCheckService;

	public RentalManager(RentalDao rentalDao,RentalAvailabilityCheckService rentalAvailabilityCheckService) {
		super();
		this.rentalDao = rentalDao;
		this.rentalAvailabilityCheckService = rentalAvailabilityCheckService;
	}

	@Override
	public DataResult<List<Rental>> getAll() {
		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll());
	}

	@Override
	public Result add(Rental rental) {
		if(this.rentalAvailabilityCheckService.checkIfRentalAvailable(rental)) {
			
			this.rentalDao.save(rental);
			return new SuccessResult("rental eklendi");
		}
		else {
			return new ErrorResult("araç şu anda kiralanamaz");
		}
		
	}
	
	
	

}
