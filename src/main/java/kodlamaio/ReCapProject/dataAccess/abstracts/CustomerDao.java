package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

//	private String firstName;
//	private String lastName;
//	private String email;
//	private String password;
//	private String companyName;
	
	
	@Query("Select new kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto(c.id,u.firstName, u.lastName, u.email, u.password, c.companyName)"
			+ "From Customer c Inner Join c.user u")
	List<CustomerDetailsDto> getCustomersDetails();
	
}
