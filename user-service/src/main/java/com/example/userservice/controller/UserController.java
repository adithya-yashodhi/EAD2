package com.example.userservice.controller;
import com.example.userservice.data.User;
import com.example.userservice.response.LoginResponse;
import com.example.userservice.response.RegisterResponse;
import com.example.userservice.response.UserResponse;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //handling user relation operation
@RequestMapping("/users") //connect backend anf=d frond end
@CrossOrigin  //allow sharing data with different web sites
public class UserController {

    @Autowired //injects dependencies automatically
    private UserService userService;

    @GetMapping(path = "/{id}") //map get id and returns a user's response by their ids
    public UserResponse getUserById(@PathVariable  Long id){
        return userService.getUserById(id);
    }

    @PostMapping //create a new user using post request and return the registration response
    public RegisterResponse createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login") //checking the  user provided email and password
    public LoginResponse loginUser(@RequestBody User user) {
        return userService.validateLogin(user.getEmail(), user.getPassword());
    }

    @PostMapping ("/validate")//validates user access using an ID and password and provides the result through a LoginResponse.
    public LoginResponse validateAccess(@RequestBody User user) {
        return userService.validateAccess(user.getId(), user.getPassword());
    }

}
