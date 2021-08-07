package kodlamaio.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Car;
import kodlamaio.ReCapProject.entities.dtos.CarDetailsDto;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Car>> getAll(){
		return carService.getAll();
	}
	
	@PostMapping("/add")
	public Result add( Car car) {
		return this.carService.add(car);
	}
	
	@GetMapping("/getCarsByBrandId")
	public DataResult<List<Car>> getCarsByBrandId(@RequestParam int id){
		return this.carService.getCarsByBrandId(id);
	}
	
	@GetMapping("/getCarsByColorId")
	public DataResult<List<Car>> getCarsByColorId(@RequestParam int id){
		return this.carService.getCarsByColorId(id);
	}
	
	@GetMapping("/getCarById")
	public DataResult<Car> getCarById(@RequestParam int id) {
		return this.carService.getCarById(id);
	}
	
	@DeleteMapping("/delete")
	public Result deleteCarById(@RequestParam int id) {
		return this.carService.deleteById(id);
	}

	@GetMapping("/getCarDetails")
	public DataResult<List<CarDetailsDto>> getCarDetails(){
		return this.carService.getCarDetails();
	}
	
	/*@PostMapping("addNewCar")
	public Result addNewCar(@RequestParam int id,@RequestParam int modelYear,@RequestParam int dailyPrice,@RequestParam String description,@RequestParam int brandId,@RequestParam int colorId) {
		return this.carService.addNewCar(id,modelYear,dailyPrice,description, brandId, colorId);
	}*/
	

	
}
