package manager.mywebappspringboot.service;

import manager.mywebappspringboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User deleteUserById(Long id);

}
