package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.dataAccess.abstracts.CarDao;
import kodlamaio.ReCapProject.entities.concretes.Car;

@Service
public class CarManager implements CarService {

	private CarDao carDao;

	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public List<Car> getAll() {
		return this.carDao.findAll();
	}

	@Override
	public void add(Car car) {
		this.carDao.save(car);
	}

	@Override
	public List<Car> getCarsByBrandId(int id) {
		return this.carDao.getCarsByBrandId(id);
	}

	@Override
	public List<Car> getCarsByColorId(int id) {
		return this.carDao.getCarsByColorId(id);
	}
	
	
}
