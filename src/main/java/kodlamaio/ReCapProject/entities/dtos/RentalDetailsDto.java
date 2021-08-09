package kodlamaio.ReCapProject.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetailsDto {

	private String brandName;
	private String colorName;
	private int dailyPrice;
	private String description;
	private int modelYear;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerCompany;
	private String customerEmail;
	private String customerPassword;
	
	private Date rentDate;
	private Date returnDate;
	
	
}
