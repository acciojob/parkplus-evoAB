package com.driver.services.impl;

import com.driver.Entities.User;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository4;
    @Override
    public void deleteUser(Integer userId) {
        userRepository4.deleteById(userId);
    }

    @Override
    public User updatePassword(Integer userId, String password) {
        Optional<User> optionalUser=userRepository4.findById(userId);
        User user=null;
        if(optionalUser.isPresent())
        {
            user=optionalUser.get();
            user.setPassword(password);
            user=userRepository4.save(user);
        }
        return  user;
    }

    @Override
    public void register(String name, String phoneNumber, String password) {
        User user=new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        userRepository4.save(user);
    }

}
