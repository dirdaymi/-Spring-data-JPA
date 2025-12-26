package mundia.louki.hospital.repositories;

import mundia.louki.hospital.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}