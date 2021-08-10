package kodlamaio.ReCapProject.business.checks.abstracts;

public interface CarPropertiesCheckService {
	
	boolean checkIfNameHasAtLeastTwoCharacters(String name);
	boolean checkIfDailyPriceMoreThanZero(int dailyPrice);
}
