package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;


import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Car;

public interface CarService {
	
	DataResult<List<Car>>  getAll();
	DataResult<Car>  getCarById(int id);
	Result add(Car car);
	Result deleteById(int id);
	

	DataResult<List<Car>> getCarsByBrandId(int id);
	DataResult<List<Car>> getCarsByColorId(int id);
}
