package kodlamaio.ReCapProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarDto {
	
	private int id;
	private String description;
	private int dailyPrice;
	private int brandId;
	private int colorId;

}
