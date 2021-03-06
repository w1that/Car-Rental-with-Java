package kodlamaio.ReCapProject.api.controllers;

import java.time.LocalDate;
import java.util.Date;
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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.abstracts.RentalService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Rental;
import kodlamaio.ReCapProject.entities.dtos.RentalDetailsDto;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin
public class RentalsController {

	private RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<Rental>> getAll(){
		return this.rentalService.getAll();
	}
	
	/*@PostMapping("/add")
	public Result add(@RequestBody Rental rental) {
		return this.rentalService.add(rental);
	}*/
	
	@PostMapping("/add")
	public Result add(@RequestParam int customerId, @RequestParam int carId) {
		return this.rentalService.add(customerId, carId);
	}
	
	@GetMapping("/getRentalDetail")
	public DataResult<List<RentalDetailsDto>> getRentalDetail(){
		return this.rentalService.getRentalDetail();
	}
	
	@DeleteMapping
	public Result delete(@RequestParam int id) {
		return this.rentalService.deleteById(id);
	}
	
	@PutMapping
	public Result setReturnDate(@RequestParam int id) {
		return this.rentalService.setReturnDate(id);
	}
	
	/*@DeleteMapping
	public Result deleteAll() {
		return this.rentalService.deleteAll();
	}*/
}
