package kodlamaio.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.ReCapProject.business.abstracts.UserService;
import kodlamaio.ReCapProject.core.dataAccess.UserDao;
import kodlamaio.ReCapProject.core.entities.User;
import kodlamaio.ReCapProject.core.utilities.results.DataResult;
import kodlamaio.ReCapProject.core.utilities.results.Result;
import kodlamaio.ReCapProject.core.utilities.results.SuccessDataResult;
import kodlamaio.ReCapProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("kullanıcı eklendi");
	}
	
}
