package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.concretes.Rental;
import kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto;

public interface RentalDao extends JpaRepository<Rental, Integer>{

	@Query("select new kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto(r.id,r.rentDate,r.returnDate,ca.dailyPrice,"
			+ "ca.description,cu) From Rental r Inner Join r.car ca Inner Join r.customer cu")
	List<RentalDetailsDto> getRentalDetail();
//	private int id;
//	private LocalDate rentDate;
//	private LocalDate returnDate;
//	private int dailyPrice;
//	private String description;
//	private Customer customer;
}
