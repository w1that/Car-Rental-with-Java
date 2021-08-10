package kodlamaio.ReCapProject.business.checks.abstracts;

import kodlamaio.ReCapProject.entities.concretes.Color;

public interface ColorPropertiesCheckService {
	
	boolean checkIfItsExist(Color color);    //checks if there is already a same color in colors table


}
