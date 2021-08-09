package kodlamaio.ReCapProject.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageDetailsDto {
	
	private int id;
	private int carId;
	private LocalDate createdAt;
	private String imagePath;

}
