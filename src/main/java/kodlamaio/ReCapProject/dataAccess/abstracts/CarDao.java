package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.dtos.CarDetailsDto;

public interface CarDao extends JpaRepository<Car, Integer>  {

	List<Car> getCarsByBrandId(int id);
	List<Car> getCarsByColorId(int id);
	
	Car getCarById(int id);
	
	@Query("Select new kodlamaio.ReCapProject.entities.dtos.CarDetailsDto(c.id, c.description, c.dailyPrice, b.name, co.name)"
			+ "From Car c Inner Join c.brand b Inner Join c.color co")
	List<CarDetailsDto> getCarDetails();
	
	/*@Query("insert into kodlamaio.ReCapProject.entities.dtos.AddCarDto(c.id, c.description, c.dailyPrice, b.id, co.id) values (:id, :description, :dailyPrice, :brandId, :colorId)"
			+ "From Car c Inner Join c.brand b Inner Join c.color co")
	void addNewCar(@Param("id") int id,@Param("description")  String description,@Param("dailyPrice")  int dailyPrice,@Param("brandId")  int brandId,@Param("colorId")  int colorId);
	*/
	
	/*@Query("insert into Car(c.id, c.modelYear, c.dailyPrice, c.description, b.id, co.id) "
			+ "select (:id,:modelYear, :dailyPrice, :description, :brandId, :colorId)"
			+ "From Car c Inner Join c.brand b Inner Join c.color co")
	void addNewCar(@Param("id") int id,@Param("modelYear")  int modelYear,
			@Param("dailyPrice")  int dailyPrice,@Param("description")  String description,
			@Param("brandId")  int brandId,@Param("colorId")  int colorId);*/
	
}
