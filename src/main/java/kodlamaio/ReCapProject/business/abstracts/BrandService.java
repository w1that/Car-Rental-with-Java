package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.core.utilities.results.Result;

import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.entities.concretes.Brand;

public interface BrandService {
	
	DataResult<List<Brand>>  getAll();
	Result  add(Brand brand);
	DataResult<Brand> getById(int id);

}
