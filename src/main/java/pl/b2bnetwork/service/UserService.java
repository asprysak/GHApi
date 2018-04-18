package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUser(User user);

    List<User> findAllUsers();

    void updateUser(User user);
}

