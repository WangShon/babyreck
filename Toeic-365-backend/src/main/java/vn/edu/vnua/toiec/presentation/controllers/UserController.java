package vn.edu.vnua.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.toiec.core.security.UserPrinciple;
import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.usecases.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserPrinciple>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<UserPrinciple> getCurrentUser() {
        return new ResponseEntity<>(userService.getCurrentUser(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<User> delete(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteUser(User user) {
        userService.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
