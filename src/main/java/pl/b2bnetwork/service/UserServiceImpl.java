package pl.b2bnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {

        User userFromDb = userRepository.findByLogin(user.getLogin());
        if(userFromDb == null) {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {

        User userFromDb = userRepository.findByLogin(user.getLogin());
        if(userFromDb != null) {
            Long idDb = userFromDb.getIdDb();
            user.setIdDb(idDb);
            userRepository.save(user);
        }
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
