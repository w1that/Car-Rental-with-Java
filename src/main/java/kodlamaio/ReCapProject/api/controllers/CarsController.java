package kodlamaio.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
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
	
	@GetMapping("/getNotBusyCars")
	public DataResult<List<Car>> getNotBusyCars(){
		return this.carService.getNotBusyCars();
	}
	
	@DeleteMapping("/deleteAll")
	public Result deleteAll() {
		return this.carService.deleteAll();
	}
	
}
