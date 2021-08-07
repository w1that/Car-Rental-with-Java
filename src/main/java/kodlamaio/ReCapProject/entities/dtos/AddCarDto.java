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
	private int modelYear;
	private int brandId;
	private int colorId;
	
	public AddCarDto(String description, int dailyPrice, int modelYear, int brandId, int colorId) {
		this.description = description;
		this.dailyPrice=dailyPrice;
		this.modelYear = modelYear;
		this.brandId=brandId;
		this.colorId=colorId;
	}

}
