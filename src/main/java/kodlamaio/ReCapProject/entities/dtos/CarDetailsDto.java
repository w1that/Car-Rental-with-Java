package kodlamaio.ReCapProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailsDto {
	private int id;
	private String description;
	private int dailyPrice;
	private String brandName;
	private String colorName;

}
