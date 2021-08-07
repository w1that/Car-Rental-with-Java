package kodlamaio.ReCapProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.entities.concretes.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {

	Color findById(int id);
}
