package com.anirudh.MovieTTBSystem.Controller;

import com.anirudh.MovieTTBSystem.Model.User;
import com.anirudh.MovieTTBSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
