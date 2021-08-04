package kodlamaio.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.abstracts.CarService;
import kodlamaio.ReCapProject.entities.concretes.Car;

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
	public List<Car> getAll(){
		return this.carService.getAll();
	}
	
	@PostMapping("/add")
	public void add( Car car) {
		this.carService.add(car);
	}
	
	//List<Car> getCarsByBrandId(int id);
	//List<Car> getCarsByColorId(int id);
	
	@GetMapping("/getCarsByBrandId")
	public List<Car> getCarsByBrandId(@RequestParam int id){
		return this.carService.getCarsByBrandId(id);
	}
	
	@GetMapping("/getCarsByColorId")
	public List<Car> getCarsByColorId(@RequestParam int id){
		return this.carService.getCarsByColorId(id);
	}
}
