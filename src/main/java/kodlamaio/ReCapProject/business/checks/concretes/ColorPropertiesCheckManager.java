package kodlamaio.ReCapProject.business.checks.concretes;


import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.ColorPropertiesCheckService;
import kodlamaio.ReCapProject.dataAccess.abstracts.ColorDao;
import kodlamaio.ReCapProject.entities.concretes.Color;

@Service
public class ColorPropertiesCheckManager implements ColorPropertiesCheckService {

	ColorDao colorDao;
	
	public ColorPropertiesCheckManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public boolean checkIfItsExist(Color color) {
		for (Color col : this.colorDao.findAll()) {
			if(col.getName()==color.getName()) {
				return true;                //if it returns true, then it means this color is already in colors table at the database
			}
		}
		return false;
	}

	
}
