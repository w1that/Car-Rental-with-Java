package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.dtos.CarDetailsDto;

public interface CarDao extends JpaRepository<Car, Integer>  {

	List<Car> getCarsByBrandId(int id);
	List<Car> getCarsByColorId(int id);
	
	Car getCarById(int id);
	
	@Query("Select new kodlamaio.ReCapProject.entities.dtos.CarDetailsDto(c.id, c.description, c.dailyPrice, b.name, co.name)"
			+ "From Car c Inner Join c.brand b Inner Join c.color co")
	List<CarDetailsDto> getCarDetails();
	
//(String description, int dailyPrice, int modelYear, int brandId, int colorId)

//	@Query("Insert Into cars()")
//	void addNewCar(String description, int dailyPrice, int modelYear, int brandId, int colorId);
	
}
