package com.ufrgs.EasyTimesheet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();

        userRepository.findAll().forEach(user -> userList.add(user));

        return userList;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmailIgnoreCase(email);

        if(user.getPwd().equals(password)){
            user.setPwd("");
            return user;
        }
        else {
            return new User();
        }
    }
    public User findByEmail(User user)
    {
        String email = user.getEmail();
        User newUser = userRepository.findByEmailIgnoreCase(email);
        newUser.setPwd("");
        return newUser;
    }
}