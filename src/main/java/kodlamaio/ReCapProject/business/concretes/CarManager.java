package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.business.checks.abstracts.CarPropertiesCheckService;
import kodlamaio.ReCapProject.business.constants.Messages;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CarDao;
import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.dtos.CarDetailsDto;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private CarPropertiesCheckService carPropertiesCheckService;
	
	@Autowired
	public CarManager(CarDao carDao, CarPropertiesCheckService carPropertiesCheckService) {
		super();
		this.carDao = carDao;
		this.carPropertiesCheckService= carPropertiesCheckService;
	}
	
	public CarManager() {
		
	}

	@Override
	public DataResult<List<Car>>  getAll() {
		return new SuccessDataResult<List<Car>>(this.carDao.findAll());
	}

	@Override
	public Result add(Car car) {
		if(carPropertiesCheckService.checkIfDailyPriceMoreThanZero(car.getDailyPrice()) && 
				carPropertiesCheckService.checkIfNameHasAtLeastTwoCharacters(car.getDescription())) {
			car.setBusy(false);
			this.carDao.save(car);
			return new SuccessResult(Messages.carAdded);
		}
		else {
			return new ErrorResult(Messages.carCouldntAdded);
		}
	}

	@Override
	public DataResult<List<Car>>  getCarsByBrandId(int id) {
		return new SuccessDataResult<List<Car>>(this.carDao.getCarsByBrandId(id));
	}

	@Override
	public DataResult<List<Car>> getCarsByColorId(int id) {
		return new SuccessDataResult<List<Car>>(this.carDao.getCarsByColorId(id));
	}

	@Override
	public DataResult<Car>  getCarById(int id) {
		return new SuccessDataResult<Car>(this.carDao.getCarById(id));
	}

	@Override
	public Result deleteById(int id) {
		this.carDao.deleteById(id);
		return new SuccessResult(Messages.carDeleted);
		
	}

	@Override
	public DataResult<List<CarDetailsDto>> getCarDetails() {
		return new SuccessDataResult<List<CarDetailsDto>>(this.carDao.getCarDetails());
	}

	@Override
	public DataResult<List<Car>> getNotBusyCars() {
		return new SuccessDataResult<List<Car>>(this.carDao.getNotBusyCars());
	}

	@Override
	public Result deleteAll() {
		this.carDao.deleteAll();
		return new SuccessResult("hepsi silindi");
	}
	
	

}
