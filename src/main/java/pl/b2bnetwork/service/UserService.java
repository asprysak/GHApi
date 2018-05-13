package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteUser(Long id);

    List<User> findAllUsers();

    void updateUser(User user);

    void deleteAll();

    User findOne(Long id);
}

