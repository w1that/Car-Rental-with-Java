package kodlamaio.ReCapProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.ReCapProject.business.abstracts.CarImageService;
import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.concretes.CarImage;

@RestController
@RequestMapping("/api/carImages")
public class CarImagesController {

	private CarImageService carImageService;
	private CarService carService;
	
	@Autowired
	public CarImagesController(CarImageService carImageService, CarService carService) {
		super();
		this.carImageService = carImageService;
		this.carService = carService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int id, @RequestParam MultipartFile imageFile) {
		Car car = this.carService.getCarById(id).getData();
		CarImage carImage = new CarImage();
		carImage.setCar(car);
		return this.carImageService.add(carImage, imageFile);
	}
	
	
}
