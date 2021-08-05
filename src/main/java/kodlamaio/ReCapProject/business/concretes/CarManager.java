package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.CarPropertiesCheckService;
import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CarDao;
import kodlamaio.ReCapProject.entities.concretes.Car;

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
			this.carDao.save(car);
			return new SuccessResult("araç eklendi");
		}
		else {
			return new ErrorResult("araç eklenemedi");
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
		return new SuccessResult("araç başarıyla silindi");
		
	}
	
	
	
	
}
