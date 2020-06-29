package com.br.zup.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.zup.models.User;
import com.br.zup.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clientes")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> creteUserDb(@Valid @RequestBody User user) {
        try {
            userService.createUserById(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping
    public ResponseEntity<?> showAllUsers() {
        try {
            return ResponseEntity.ok().body(userService.takeUser());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetUserDb(@PathVariable Long id) {
        try {
            User user = userService.takeById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDb(@PathVariable Long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok().body(userService.updateUser(id, user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDb(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
