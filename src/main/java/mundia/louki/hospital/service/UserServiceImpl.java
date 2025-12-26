package mundia.louki.hospital.service;

import mundia.louki.hospital.entities.Role;
import mundia.louki.hospital.entities.User;
import mundia.louki.hospital.repositories.RoleRepository;
import mundia.louki.hospital.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user); // Pour la cohérence OO
        }
        // Pas besoin de .save() car @Transactional commite les modifs
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}