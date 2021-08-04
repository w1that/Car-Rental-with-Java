package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.entities.concretes.Car;

public interface CarDao extends JpaRepository<Car, Integer>  {

	List<Car> getCarsByBrandId(int id);
	List<Car> getCarsByColorId(int id);
}
