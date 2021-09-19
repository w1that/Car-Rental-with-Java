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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.ReCapProject.business.abstracts.ColorService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Color;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorsController {

	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Color>> getAll(){
		return this.colorService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Color color) {
		return this.colorService.add(color);
	}
	
	@DeleteMapping("/deleteById")
	public Result deleteById(@RequestParam int id) {
		return this.colorService.deleteById(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Color> getById(@RequestParam int id) {
		return this.colorService.getById(id);
	}
	
}
