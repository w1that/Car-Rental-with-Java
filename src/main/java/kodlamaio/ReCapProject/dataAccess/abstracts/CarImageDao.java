package kodlamaio.ReCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.entities.concretes.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{

}
