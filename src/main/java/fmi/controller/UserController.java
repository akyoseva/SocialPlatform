package fmi.controller;

import fmi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fmi.service.UserService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/users")
@Transactional
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void add(@RequestBody User user){
        userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        User user = userService.findById(id);
        userService.delete(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }
}
