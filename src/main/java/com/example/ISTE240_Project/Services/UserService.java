package com.example.ISTE240_Project.Services;


import com.example.ISTE240_Project.Models.User;
import com.example.ISTE240_Project.modelsDAO.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
