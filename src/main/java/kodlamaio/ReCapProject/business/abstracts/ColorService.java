package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;


import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.concretes.Color;

public interface ColorService {
	
	DataResult<List<Color>>  getAll();
	Result add(Color color);
	Result deleteById(int id);
	DataResult<Color> getById(int id);
}
