package kodlamaio.ReCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer>{

}
