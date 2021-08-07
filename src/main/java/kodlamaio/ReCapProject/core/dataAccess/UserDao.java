package kodlamaio.ReCapProject.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.ReCapProject.core.entities.User;
import kodlamaio.ReCapProject.entities.dtos.UserDto;

public interface UserDao extends JpaRepository<User, Integer> {
//	private int id;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String password;
	//@Query("Select new kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto(c.id,u.firstName, u.lastName, u.email, u.password, c.companyName)"
	//		+ "From Customer c Inner Join c.user u")
	@Query("Select new kodlamaio.ReCapProject.entities.dtos.UserDto(u.id, u.firstName, u.lastName, u.email, u.password)"
			+ "From User u")
	List<UserDto> getUserDetails();
}
