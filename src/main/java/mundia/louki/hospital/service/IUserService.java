package mundia.louki.hospital.service;

import mundia.louki.hospital.entities.Role;
import mundia.louki.hospital.entities.User;

public interface IUserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    void addRoleToUser(String username, String roleName);
    User findUserByUserName(String username);
}