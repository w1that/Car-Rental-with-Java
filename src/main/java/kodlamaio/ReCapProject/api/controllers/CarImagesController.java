package kodlamaio.ReCapProject.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.ReCapProject.business.abstracts.CarImageService;
import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.concretes.CarImage;


@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class CarImagesController {

	private CarImageService imageService;
	private CarService carService;

	@Autowired
	public CarImagesController(CarImageService imageService,CarService carService) {
		super();
		this.imageService = imageService;
		this.carService = carService;
	}

	@PostMapping(value="/add" )
	public Result add(@RequestParam(value = "id") int id, @RequestPart MultipartFile imageFile) {
		Car car = this.carService.getCarById(id).getData();
		CarImage carImage = new CarImage();
		carImage.setCar(car);
		return this.imageService.upload(carImage, imageFile);
		
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<CarImage>> getAll(){
		return this.imageService.getAll();
	}
	
}
