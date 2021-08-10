package kodlamaio.ReCapProject.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.abstracts.CarImageService;
import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.concretes.CarImage;
import kodlamaio.ReCapProject.entities.dtos.CarImageDetailsDto;


@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class CarImagesController {

	private CarImageService carImageService;
	private CarService carService;

	@Autowired
	public CarImagesController(CarImageService carImageService,CarService carService) {
		super();
		this.carImageService = carImageService;
		this.carService = carService;
	}

	@PostMapping(value="/add" )
	public Result add(@RequestParam(value = "id") int id, @RequestPart MultipartFile imageFile) {
		Car car = this.carService.getCarById(id).getData();
		CarImage carImage = new CarImage();
		carImage.setCar(car);
		return this.carImageService.upload(id,carImage, imageFile);
		
	}
	
	@DeleteMapping("/deleteById")
	public Result deleteById(int id) {
		return this.carImageService.deleteById(id);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<CarImage>> getAll(){
		return this.carImageService.getAll();
	}
	
	@GetMapping(value="/getByCarId")
	public DataResult<List<CarImage>> getByCarId(@RequestParam int id) {
		return this.carImageService.getByCarId(id);
	}
	
	@GetMapping(value="getByCarImageDetails")
	public DataResult<List<CarImageDetailsDto>> getCarImageDetails(){
		return this.carImageService.getCarImageDetails();
	}
}
