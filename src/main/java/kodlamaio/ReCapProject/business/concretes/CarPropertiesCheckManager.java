package kodlamaio.ReCapProject.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.CarPropertiesCheckService;

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
