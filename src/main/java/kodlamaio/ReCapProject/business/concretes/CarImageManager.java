package kodlamaio.ReCapProject.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.ReCapProject.business.abstracts.CarImageService;
import kodlamaio.ReCapProject.core.utilities.imageUpload.ImageUploadService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CarImageDao;
import kodlamaio.ReCapProject.entities.concretes.CarImage;

@Service
public class CarImageManager implements CarImageService{

	private CarImageDao carImageDao;
	private ImageUploadService imageUploadService;

	public CarImageManager(CarImageDao carImageDao,ImageUploadService imageUploadService) {
		super();
		this.carImageDao = carImageDao;
		this.imageUploadService=imageUploadService;
	}

	@Override
	public Result add(CarImage carImage, MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		carImage.setImagePath(uploadImage.get("url"));
		this.carImageDao.save(carImage);
		return new SuccessResult("resim eklendi");
	}

	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<List<CarImage>>(this.carImageDao.findAll());
	}

	
	
}
