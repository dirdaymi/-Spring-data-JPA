package mundia.louki.hospital.repositories;

import mundia.louki.hospital.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}