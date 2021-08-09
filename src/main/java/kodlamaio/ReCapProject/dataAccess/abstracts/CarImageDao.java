package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.ReCapProject.entities.concretes.CarImage;
import kodlamaio.ReCapProject.entities.dtos.CarImageDetailsDto;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{

	List<CarImage> getByCarId(int carId);
	
	@Query("select new kodlamaio.ReCapProject.entities.dtos.CarImageDetailsDto(c.id, ca.id, c.createdAt, c.imagePath)"
			+ "From CarImage c Inner Join Car ca")
	List<CarImageDetailsDto> getCarImageDetails();
}

