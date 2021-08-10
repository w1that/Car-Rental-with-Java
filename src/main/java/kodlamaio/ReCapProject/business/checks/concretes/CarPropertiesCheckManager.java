package kodlamaio.ReCapProject.business.checks.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.checks.abstracts.CarPropertiesCheckService;

@Service
public class CarPropertiesCheckManager implements CarPropertiesCheckService {

	@Override
	public boolean checkIfNameHasAtLeastTwoCharacters(String name) {
		if(name.length()<2) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIfDailyPriceMoreThanZero(int dailyPrice) {
		if(dailyPrice<=0) {
			return false;
		}
		return true;
	}

}
