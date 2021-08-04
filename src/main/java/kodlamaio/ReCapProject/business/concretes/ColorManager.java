package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.ColorService;
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
	public List<Color> getAll() {
		return this.colorDao.findAll();
	}

	@Override
	public void add(Color color) {
		this.colorDao.save(color);
	}

	
}
