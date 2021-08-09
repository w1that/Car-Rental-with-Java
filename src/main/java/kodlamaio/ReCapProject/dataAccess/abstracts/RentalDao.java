package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.ReCapProject.entities.concretes.Rental;
import kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto;

public interface RentalDao extends JpaRepository<Rental, Integer>{

//	@Query("Select new kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto(c.brand.name, c.color.name, c.dailyPrice, c.description, c.modelYear,"
//			+ "cu.firstName, cu.lastName, cu.companyName, cu.email, cu.password, r.rentDate, r.returnDate) "
//			+ "From Rental r inner join r.car c inner join r.customer cu")
//	List<RentalDetailsDto> getRentalsDetails();
}
