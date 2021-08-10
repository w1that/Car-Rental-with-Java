package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.CarImage;
import kodlamaio.ReCapProject.entities.dtos.CarImageDetailsDto;

public interface CarImageService {

	Result upload (int carId,CarImage carImage,MultipartFile file);
	DataResult<List<CarImage>> getAll();
	Result deleteById(int id);
	
	DataResult<List<CarImage>> getByCarId(int id);
	DataResult<List<CarImageDetailsDto>> getCarImageDetails();
	
}
