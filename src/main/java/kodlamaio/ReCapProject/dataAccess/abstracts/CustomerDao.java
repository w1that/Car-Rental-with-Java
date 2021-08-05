package kodlamaio.ReCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
