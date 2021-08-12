package kodlamaio.ReCapProject.business.concretes;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.ReCapProject.business.abstracts.CarImageService;
import kodlamaio.ReCapProject.business.constants.Messages;
import kodlamaio.ReCapProject.core.utilities.imageUpload.ImageUploadService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.ErrorResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.CarImageDao;
import kodlamaio.ReCapProject.entities.concretes.CarImage;
import kodlamaio.ReCapProject.entities.dtos.CarImageDetailsDto;

@Service
public class CarImageManager implements CarImageService{

	CarImageDao carImageDao;
	ImageUploadService imageUploadService;
	
	
	
	public CarImageManager(CarImageDao carImageDao, ImageUploadService imageUploadService) {
		super();
		this.carImageDao = carImageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result upload(int carId,CarImage carImage, MultipartFile file) {
		
		if(this.carImageDao.getByCarId(carId).size()<5) {
			@SuppressWarnings("unchecked")
			Map<String,String> uploadedImage=(Map<String,String>)this.imageUploadService.upload(file).getData();
			carImage.setImagePath(uploadedImage.get("url"));
			this.carImageDao.save(carImage);
			
			return new SuccessResult(Messages.photoAdded);
		}
		return new ErrorResult(Messages.photoNumberError);
		
	}

	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<List<CarImage>>(this.carImageDao.findAll());
	}

	@Override
	public DataResult<List<CarImage>> getByCarId(int id) {
		return new SuccessDataResult<List<CarImage>>(this.carImageDao.getByCarId(id));
	}

	@Override
	public DataResult<List<CarImageDetailsDto>> getCarImageDetails() {
		return new SuccessDataResult<List<CarImageDetailsDto>>(this.carImageDao.getCarImageDetails());
	}

	@Override
	public Result deleteById(int id) {
		this.carImageDao.deleteById(id);
		return new SuccessResult(Messages.photoDeleted);
	}

}
