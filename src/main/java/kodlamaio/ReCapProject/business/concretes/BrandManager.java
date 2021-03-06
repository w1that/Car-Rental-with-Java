package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.ReCapProject.business.abstracts.BrandService;
import kodlamaio.ReCapProject.business.constants.Messages;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
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
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(this.brandDao.findAll());
	}

	@Override
	public Result add(Brand brand) {
		this.brandDao.save(brand);
		return new SuccessResult(Messages.brandAdded);
	}

	@Override
	public DataResult<Brand> getByBrandId(int id) {
		
		return new SuccessDataResult<Brand>(this.brandDao.findById(id));     //?
	}
}
