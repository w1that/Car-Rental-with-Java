package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.entities.concretes.Color;

public interface ColorService {
	
	List<Color> getAll();
	void add(Color color);
}
