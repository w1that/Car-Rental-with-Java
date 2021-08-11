package kodlamaio.ReCapProject.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.ReCapProject.entities.concretes.Customer;
import kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
	@Query("Select new kodlamaio.ReCapProject.entities.dtos.CustomerDetailsDto(c.id,c.firstName, c.lastName, c.email, c.password, c.companyName)"
			+ "From Customer c ")
	List<CustomerDetailsDto> getCustomersDetails();
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.isActivated=true where c.id=:id ")
	void setActivated(int id);
	
	Customer getByEmail(String email);
}
