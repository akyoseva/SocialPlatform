package fmi.service;

import fmi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fmi.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user){
        userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("User with this id " + id +" doesn't exist."));
    }
}
