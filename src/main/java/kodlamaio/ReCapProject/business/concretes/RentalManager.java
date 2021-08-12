package kodlamaio.ReCapProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.RentalService;
import kodlamaio.ReCapProject.business.checks.abstracts.RentalAvailabilityCheckService;
import kodlamaio.ReCapProject.business.constants.Messages;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CarDao;
import kodlamaio.ReCapProject.dataAccess.abstracts.CustomerDao;
import kodlamaio.ReCapProject.dataAccess.abstracts.RentalDao;
import kodlamaio.ReCapProject.entities.concretes.Rental;
import kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto;
@Service
public class RentalManager implements RentalService{
	
	@Autowired
	private CustomerDao customerDao;
	private RentalDao rentalDao;
	private RentalAvailabilityCheckService rentalAvailabilityCheckService;
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
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
		if(!rentalAvailabilityCheckService.checkIfRentalAvailable(rental).isSuccess()) {
			return rentalAvailabilityCheckService.checkIfRentalAvailable(rental);
		}
		rental.setRentDate(LocalDate.now());
		rental.getCar().setBusy(true);
		this.rentalDao.save(rental);
		this.carDao.setBusy(rental.getCar().getId());
		return new SuccessResult(Messages.rentalAdded);
		
		
		
		
		
	}

	@Override
	public DataResult<List<RentalDetailsDto>> getRentalDetail() {
		return new SuccessDataResult<List<RentalDetailsDto>>(this.rentalDao.getRentalDetail());
	}

}
