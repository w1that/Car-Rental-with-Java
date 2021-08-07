package kodlamaio.ReCapProject.business.abstracts;

import java.util.List;

import kodlamaio.ReCapProject.core.entities.User;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.entities.dtos.UserDto;

public interface UserService {

	DataResult<List<User>> getAll();
	Result add(User user);
	
	DataResult<List<UserDto>> getUsersWithDetails();
}
