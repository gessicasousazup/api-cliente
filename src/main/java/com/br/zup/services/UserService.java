package com.br.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.zup.models.User;
import com.br.zup.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUserById(User user) {
        userRepository.save(user);
    }

    public Iterable<User> takeUser() {
        return userRepository.findAll();
    }

    public User takeById(Long id) {
        return userRepository.findById(id).get();
    }

    public Long quantityUser() {
        return userRepository.count();
    }

    public User updateUser(Long id, User update) {
        User teste = new User();
        teste = userRepository.findById(id).get();

        if (teste != null) {
            update.setId(id);
            return userRepository.save(update);

        }
        return null;

    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
