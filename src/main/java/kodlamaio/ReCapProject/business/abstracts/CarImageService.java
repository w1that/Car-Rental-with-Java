package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.CarImage;

public interface CarImageService {

	Result add(CarImage carImage, MultipartFile imageFile);
	DataResult<List<CarImage>> getAll();
}