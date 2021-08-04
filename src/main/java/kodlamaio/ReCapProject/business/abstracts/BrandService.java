package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.entities.concretes.Brand;

public interface BrandService {
	
	List<Brand> getAll();
	void add(Brand brand);

}
