package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.ColorService;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;
import kodlamaio.ReCapProject.dataAccess.abstracts.ColorDao;
import kodlamaio.ReCapProject.entities.concretes.Color;

@Service
public class ColorManager  implements ColorService{

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<Color>>  getAll() {
		return new SuccessDataResult<List<Color>>(this.colorDao.findAll());
	}

	@Override
	public Result add(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("renk başarıyla eklendi");
	}

	@Override
	public Result deleteById(int id) {
		this.colorDao.deleteById(id);
		return new SuccessResult("renk başarıyla silindi");
	}

	@Override
	public DataResult<Color> getById(int id) {
		return new SuccessDataResult<Color>(this.colorDao.getById(id));
	}

	
}
