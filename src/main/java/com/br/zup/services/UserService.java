package com.br.zup.services;

import com.br.zup.api.Exception.ObjectNotFoundException;
import com.br.zup.entity.dto.UserDTO;
import com.br.zup.entity.model.User;
import com.br.zup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(User user) {
        Assert.isNull(user.getId(),"Não foi possível inserir o registro do usuario");
        return UserDTO.create(userRepository.save(user));
    }

    public List<UserDTO> getUsers() {
        List<UserDTO> list = userRepository.findAll().stream().map(UserDTO::create).collect(Collectors.toList());
        return list;
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserDTO ::create).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    public UserDTO update(User user, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            User db = optional.get();
            db.setFullName(user.getFullName());
            db.setAge(user.getAge());
            db.setPhone(user.getPhone());
            db.setCpf(user.getCpf());
            db.setEmail(user.getEmail());
            System.out.println("User id " + db.getId());

            userRepository.save(db);

            return UserDTO.create(db);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}

