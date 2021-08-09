package kodlamaio.ReCapProject.entities.dtos;

import java.time.LocalDate;

import kodlamaio.ReCapProject.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetailsDto {

	private int id;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int dailyPrice;
	private String description;
	private Customer customer;
}
