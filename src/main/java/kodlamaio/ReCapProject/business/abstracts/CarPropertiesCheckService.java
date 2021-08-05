package kodlamaio.ReCapProject.business.abstracts;

public interface CarPropertiesCheckService {
	
	boolean checkIfNameHasAtLeastTwoCharacters(String name);
	boolean checkIfDailyPriceMoreThanZero(int dailyPrice);
}
