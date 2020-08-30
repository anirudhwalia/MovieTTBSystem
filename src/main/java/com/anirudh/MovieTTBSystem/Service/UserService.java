package com.anirudh.MovieTTBSystem.Service;

import com.anirudh.MovieTTBSystem.Model.User;
import com.anirudh.MovieTTBSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
       return userRepository.save(user);
    }

}
