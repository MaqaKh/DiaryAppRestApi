package com.diary.app.controller;

import com.diary.app.entity.User;
import com.diary.app.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/main")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User login(@RequestBody User reqParams) {
        String username = reqParams.getUserName();
        String password = reqParams.getPassword();

        User user = userRepository.findByUserNameAndPassword(username, password);
        if (user == null){
            System.out.println("User is not found");
            return new User();
        }
        return user;
    }

    @PostMapping("/user")
    public void save(@RequestBody User user){
        if(user==null)
            throw new RuntimeException("user body is null");
        userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User findAll(@PathVariable("id") long id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/saveUser")
    public User saveUser(){
        User user=new User();
        user.setFirstName("Laman");
        user.setPassword("laman");
        return userRepository.save(user);
    }
}
