package kodlamaio.ReCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.entities.concretes.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

}
