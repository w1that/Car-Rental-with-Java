package kodlamaio.ReCapProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.ReCapProject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
