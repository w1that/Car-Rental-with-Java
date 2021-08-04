package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.BrandService;
import kodlamaio.ReCapProject.dataAccess.abstracts.BrandDao;
import kodlamaio.ReCapProject.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandDao brandDao;
	
	@Autowired
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}

	@Override
	public List<Brand> getAll() {
		return this.brandDao.findAll();
	}

	@Override
	public void add(Brand brand) {
		this.brandDao.save(brand);
	}
	
	
}
