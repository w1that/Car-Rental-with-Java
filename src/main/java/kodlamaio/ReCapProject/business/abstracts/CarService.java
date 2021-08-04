package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.entities.concretes.Car;

public interface CarService {
	
	List<Car> getAll();
	void add(Car car);

	List<Car> getCarsByBrandId(int id);
	List<Car> getCarsByColorId(int id);
}
